edge(g1,g5,4). 
edge(g2,g5,6).
edge(g3,g5,8). 
edge(g4,g5,9). 
edge(g1,g6,10). 
edge(g2,g6,9). 
edge(g3,g6,3).  
edge(g4,g6,5). 
edge(g5,g7,3). 
edge(g5,g10,4). 
edge(g5,g11,6). 
edge(g5,g12,7). 
edge(g5,g6,7). 
edge(g5,g8,9). 
edge(g6,g8,2). 
edge(g6,g12,3). 
edge(g6,g11,5). 
edge(g6,g10,9). 
edge(g6,g7,10). 
edge(g7,g10,2). 
edge(g7,g11,5). 
edge(g7,g12,7). 
edge(g7,g8,10). 
edge(g8,g9,3). 
edge(g8,g12,3). 
edge(g8,g11,4). 
edge(g8,g10,8). 
edge(g10,g15,5). 
edge(g10,g11,2). 
edge(g10,g12,5). 
edge(g11,g15,4). 
edge(g11,g13,5). 
edge(g11,g12,4). 
edge(g12,g13,7). 
edge(g12,g14,8). 
edge(g15,g13,3). 
edge(g13,g14,4). 
edge(g14,g17,5). 
edge(g14,g18,4).
edge(g17,g18,8).
start(g1).
start(g2).
start(g3).
start(g4).
dfs(g17, Path, _) :- append(Path, [g17], UpdatedPath), atomic_list_concat(UpdatedPath, ' -> ', Atom), 
    atom_string(Atom, String),format('~w~n', String),open('output.txt', append, Stream),
    write(Stream, String),nl(Stream),close(Stream).
dfs(Gate, Path, TotalDistance) :-(not(member(Gate, Path)) -> append(Path, [Gate], UpdatedPath),
    forall(edge(Gate, NextGate, Distance); edge(NextGate, Gate, Distance), 
    (UpdatedDistance is TotalDistance + Distance, dfs(NextGate, UpdatedPath, UpdatedDistance)));write("")).
optimal_dfs(g17, Path, TotalDistance) :- 
    append(Path, [g17], UpdatedPath), 
    nb_getval(minimumDist, MinimumDist),
    UpdatedMinimumDist is min(MinimumDist, TotalDistance),
    nb_setval(minimumDist, UpdatedMinimumDist),
    (UpdatedMinimumDist =:= TotalDistance -> nb_setval(minimumPath, UpdatedPath); write("")).
optimal_dfs(Gate, Path, TotalDistance) :-(not(member(Gate, Path)) -> append(Path, [Gate], UpdatedPath),
            forall(edge(Gate, NextGate, Distance), 
            (UpdatedDistance is TotalDistance + Distance, optimal_dfs(NextGate, UpdatedPath, UpdatedDistance)));write("")).
find_all_possible_paths() :-
    forall(start(X), dfs(X, [], 0)).
optimal() :-
    nb_setval(minimumDist, 10000000),
    nb_setval(minimumPath, []),
    forall(start(Gate), optimal_dfs(Gate, [], 0)),
    nb_getval(minimumDist, OptimalDistance),
    format('Optimal Distance :- ~d~n', OptimalDistance),
    nb_getval(minimumPath, Path),
    atomic_list_concat(Path, ' -> ', Atom), atom_string(Atom, String),
    format('Optimal Path :- ~w~n', String).
check_edges([g17]).
check_edges([Gate, NextGate|Tail]) :-
    (edge(Gate, NextGate, _) ; edge(NextGate, Gate, _)),
    % Check remaining path recursively
    check_edges([NextGate|Tail]).
valid([Gate|Tail]) :-start(Gate),check_edges([Gate|Tail]).