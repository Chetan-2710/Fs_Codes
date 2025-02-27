// Write a MongoDB query to calculate the average score from the "final" exam 
// for each subject across all students, print the output in the sorted order 
// of the subject names.

// Sample Output:
// ---------------
// [                                                                               
//   {                                                                             
//     subject: 'C',                                                               
//     averageFinalScore: 75                                                       
//   },                                                                            
//   {                                                                             
//     subject: 'C++',                                                             
//     averageFinalScore: 68.75                                                    
//   }
// ]

printjson(
	db.stucollection.aggregate([
	    {$unwind:"$exams"},
	    {$unwind:"$exams.scores"},
	    {$match:{"exams.scores.type":"final"}},
	    {$group:{_id:"$exams.subject",avg:{$avg:"$exams.scores.score"}}},
	    {$sort:{_id:1}},
	    {$project:{_id:0,subject:"$_id",averageFinalScore:{$round:["$avg",2]}}}
	])
)