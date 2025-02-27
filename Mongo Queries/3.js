// Write a MongoDB query to compute each student’s overall average score (rounded 
//     to 2 decimals) from all exam score entries and sort the data by student_id.

//     Sample Output:
//     ---------------
//     [                                                                               
//       {                                                                             
//         student_id: 'S1001',                                                        
//         name: 'Alice Johnson',                                                      
//         averageScore: 77.5                                                          
//       },                                                                            
//       {                                                                             
//         student_id: 'S1002',                                                        
//         name: 'Bob Smith',                                                          
//         averageScore: 57.5                                                          
//       }
//     ]

printjson(
	db.stucollection.aggregate([
	    {$unwind:"$exams"},
	    {$unwind:"$exams.scores"},
	    {$group:{_id:"$student_id",name:{$first:"$name"},avg:{$avg:"$exams.scores.score"}}},
	    {$sort:{_id:1}},
	    {$project:{_id:0,student_id:"$_id",name:"$name",averageScore:{$round:["$avg",2]}}}
	])
)