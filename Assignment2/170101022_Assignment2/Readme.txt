For question2:

%Data
bus(123,amingaon,jalukbari,12,12.2,30,10).
bus(123,jalukbari,maligaon,12.2,15,110,10).
bus(123,maligaon,lokhra,15,15.5,50,10).
bus(123,lokhra,chandmari,15.5,16,50,10).
bus(153,amingaon,paltanbazar,14.5,14.6,10,20).
bus(153,paltanbazar,maligaon,14.7,14.8,10,20).
bus(153,maligaon,chandmari,14.9,15.2,20,20).
bus(327,amingaon,maligaon,14,14.2,100,30).
bus(327,maligaon,chandmari,14.2,14.5,100,30).
bus(832,amingaon,chandmari,14,17,30,40).

Sample Input:
?- route(amingaon,chandmari).

For question3:
?- find_all_possible_paths().
?- optimal().
?- valid([g1,g6,g8,g9,g8,g7,g10,g15,g13,g14,g18,g17]).