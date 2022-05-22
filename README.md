# SelenSonmez-343TermProject

p=Number of facility that we want to open among candidate locations
First assign a min value initialy setted to a huge value( maybe from choosing the highest total distance that a one of the candidate factory have and increase it by one)


While//Number of facilities we opened is greater than zero
  Find total dictance that a candidate factory have 
    for 0-facs.lenght
            for 0-points.lenght
                     sum each row and set it to total distance
          
    Then find smallesst total disatnce then second ,third(untillamout of factory number that we want to open ... (by creating   previousmin and each time want a greater value from previousmin
     After finding th min store it index then add it to OpenedFacs arraylistprint then print "We opened index'th factory. 
     
  
Then among the factories we opened, we find which one is closest to point x. by
                for x=0-points.lenght
                          for y=0-openedfacs.size 
                                     if --->compares each column in distance matrix with corresponding indexes and assigns point x to an opened factory which point x is closest  
                                     
                                     
                                     
                                     
  EXECUTİON TİME COMPARİSON
  
Candidate fact number 5
Point 20
p=4
Time: 6201885186441
  
Candidate fact number 5
Point 20
p=3
Time :7421587312290


Candidate fact number 5
Point 20
p=2
Time : 7242841002146


Candidate fact number 5
Point 20
p=1
Time :7290860004719

Generally, the duration increases when we keep the candidate positions and points constant and decrease the p.







Candidate fact number 7
Point 20
p=4
Time: 6291833875982


Candidate fact number 7
Point 22
p=4
Time: 6348598132139



Candidate fact number 7
Point 30
p=4
Time:6403639950139

If we keep the candidate positions and p (the number of factories we want to open) constant and increase the number of points, the time increases.




Candidate fact number 5
Point 20
p=4
Time: 6201885186441


Candidate fact number 7
Point 20
p=4
Time: 6291833875982
                                     
                                     
                                                                        
Candidate fact number 8
Point 20
p=4
Time:7692270407635


When we keep the number of points and p (the number of factories we want to open) constant and increase the candidate positions, the time increases again.

