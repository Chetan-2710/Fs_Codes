/*

Find the customers who placed orders that include more items than any other 
order they’ve placed:
Sample Output:
==============

OrderID Name    ItemCount                                                                                               
1010    Charlie Davis   2                                                                                               
1005    Diana Williams  2                                                                                               
1006    Ethan Brown     2                                                                                               
1007    Fiona Adams     1                                                                                               
1008    George Clark    2                                                                                               
                                                                                             


Customers:
==========
Field   Type    Null    Key     Default Extra                                                                           
CustomerID      int     NO      PRI     NULL                                                                            
Name    varchar(255)    YES             NULL                                                                            
Email   varchar(255)    YES             NULL                                                                            
Address varchar(255)    YES             NULL                                                                            
PhoneNumber     varchar(20)     YES             NULL                                                                    

Orders:
=======
Field   Type    Null    Key     Default Extra                                                                           
OrderID int     NO      PRI     NULL                                                                                    
CustomerID      int     YES     MUL     NULL                                                                            
OrderDate       date    YES             NULL                                                                            
TotalCost       decimal(10,2)   YES             NULL                                                                    
Status  varchar(20)     YES             NULL                                                                            

OrderItems:
============
Field   Type    Null    Key     Default Extra                                                                           
OrderItemID     int     NO      PRI     NULL                                                                            
OrderID int     YES     MUL     NULL                                                                                    
ProductID       int     YES     MUL     NULL                                                                            
Quantity        int     YES             NULL                                                                            
UnitPrice       decimal(10,2)   YES             NULL                                                                    

Products:
=========
Field   Type    Null    Key     Default Extra                                                                           
ProductID       int     NO      PRI     NULL                                                                            
Name    varchar(255)    YES             NULL                                                                            
Description     varchar(255)    YES             NULL                                                                    
Price   decimal(10,2)   YES             NULL  


*/

use fs;

select o.OrderID, c.Name, count(*) ItemCount
from Orders o
join Customers c on o.CustomerID=c.CustomerID
join OrderItems oi on o.OrderID=oi.OrderID
group by o.OrderID, c.CustomerID, c.Name
having count(oi.ProductID) > all (
    select count(oi2.ProductID) 
    from Orders o2 
    join OrderItems oi2 on o2.OrderID=oi2.OrderID
    where o2.CustomerID=c.CustomerID and o.OrderID<>o2.OrderID
    group by o2.OrderID
)
order by c.Name;