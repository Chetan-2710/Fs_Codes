// Write a MongoDB query to identify the student with the highest average score 
// specifically for the "Python" subject.

// Sample Output:
// ---------------
// [                                                                               
//   {                                                                             
//     student_id: 'S1006',                                                        
//     name: 'Sophia White',                                                       
//     avgPythonScore: 87.67                                                       
//   }                                                                             
// ] 


printjson(
	db.stucollection.aggregate([
	    {$unwind:"$exams"},
	    {$match:{"exams.subject":"Python"}},
	    {$unwind:"$exams.scores"},
	    {$group:{_id:"$student_id",name:{$first:"$name"},avg:{$avg:"$exams.scores.score"}}},
	    {$sort:{avg:-1}},
	    {$limit:1},
	    {$project:{_id:0,student_id:"$_id",name:"$name",avgPythonScore:{$round:["$avg",2]}}}
	])
)