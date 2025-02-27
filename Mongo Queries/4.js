// Write a MongoDB query to retrieve guardian contact information for students
// who have failed at least one exam

// Sample Output:
// ---------------
// [
//   {
//     student_id: 'S1002',
//     name: 'Bob Smith',
//     guardian: {
//       name: 'Emma Smith',
//       relation: 'Mother',
//       contact: 'emma.s@example.com'
//     }
//   }
// ]

printjson(db.stucollection.aggregate([
  {$unwind: '$exams'}, {$match: {'exams.passed': false}}, {
    $project: {
      _id: 0,
      student_id: '$student_id',
      name: '$name',
      guardian: '$guardian'
    }
  }
]))
