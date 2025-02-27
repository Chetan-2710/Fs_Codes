const mongoose = require('mongoose');
const WebSocket = require('ws');

const wss = new WebSocket.Server({ port: 8081 });
const AutoIncrement = require("mongoose-sequence")(mongoose);

mongoose.connect("mongodb://127.0.0.1:27017/webSocket").then(() => {
    console.log("Connected to DB");
}).catch((err) => {
    console.log(err);
});


const userSchema = new mongoose.Schema({
    userId: Number,
    name: String,
    salary: Number,
    role: String,
    department: String,
    experience: Number,
});


userSchema.plugin(AutoIncrement, { inc_field: "userId" });

const User = mongoose.model("User", userSchema);

wss.on('connection', (ws) => {
    console.log('Client Connected');

    ws.on('message', async (message) => {
        console.log(`Received: ${message}`);

        const parts = message.toString().split(' ');
        const command = parts[0].toUpperCase();

        if (command === 'INSERT' && parts.length === 6) {

            const name = parts[1];
            const salary = parseInt(parts[2], 10);
            const role = parts[3];
            const department = parts[4];
            const experience = parseInt(parts[5], 10);

            if (!isNaN(salary) && !isNaN(experience)) {
                const newUser = new User({ name, salary, role, department, experience });
                const emp=await newUser.save();
                ws.send(`Employee inserted successfully. ID: ${emp.userId}`);
            } else {
                ws.send('Invalid salary or experience.');
            }

        } else if (command === 'RETRIEVE') {
            try {
                const emps = await User.find({});
                const emplist = emps.map(emp =>
                    `ID: ${emp.userId}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`
                ).join('\n');

                ws.send(emplist || 'No employees found.');
            } catch (err) {
                ws.send('Error retrieving employees.');
            }

        } else if (command === 'RETRIEVE_BY_DEPT' && parts.length === 2) {
            try {
                const emps = await User.find({ department: parts[1] });
                const emplist = emps.map(emp =>
                    `ID: ${emp.userId}, Name: ${emp.name}, Salary: ${emp.salary}, Role: ${emp.role}, Department: ${emp.department}, Experience: ${emp.experience} years`
                ).join('\n');

                ws.send(emplist || 'No employees found.');
            } catch (err) {
                ws.send('Error retrieving employees by department.');
            }

        } else {
            ws.send('Invalid command.');
        }
    });

    ws.on('close', () => {
        console.log('Client disconnected.');
    });
});

console.log('WebSocket server running on port 8081');
