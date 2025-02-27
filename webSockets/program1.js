const WebSocket=require('ws');

const wss=new WebSocket.Server({port:8081});
let emps=[];
let empId=1;

wss.on('connection',(ws)=>{
    console.log('Client Connected');

    ws.on('message', (message)=>{
        console.log(`Received: ${message}`);
        const parts=message.toString().split(' ');
        const command=parts[0].toUpperCase();
        if(command==='INSERT' && parts.length==3){
            const name=parts[1];
            const salary=parseInt(parts[2],10);
            if(!isNaN(salary)){
                emps.push({id:empId++,name,salary});
                ws.send('Employee inserted successfully.');
            }else{
                ws.send('Invalid command');
            }
        }else if(command==='RETRIEVE'){
            const emplist=emps.map(emp=> `ID: ${emp.id}, Name: ${emp.name}, Salary: ${emp.salary}`).join('\n');
            ws.send(emplist || 'No employees found.');
        }else {
            ws.send('Invalid command.');
        }
    });

    ws.on('close',()=>{
        console.log('Client disconnexted.');
    })
})

console.log('WebSocket server running on port 8081');