// Write a MongoDB query for students older than 20, display the student’s name 
// along with the number of courses they’re enrolled in.

// Sample Output:
// ---------------
// [                                                                               
// [                                                                               
//   {                                                                             
//     student_id: 'S1004',                                                        
//     name: 'David Brown',                                                        
//     enrolledCoursesCount: 2                                                     
//   },                                                                            
//   {                                                                             
//     student_id: 'S1005',                                                        
//     name: 'Ethan Harris',                                                       
//     enrolledCoursesCount: 2                                                     
//   }
// ]

printjson(
	db.stucollection.aggregate([
	    {$match:{"age":{$gt:20}}},
	    {$project:{_id:0,student_id:1,name:1,enrolledCoursesCount:{$size:"$enrolled_courses"}}}
	])
)