import Data.List 
import Data.Maybe
-- listing slots available
slots = [("1-12-2020","9:30 AM"),("1-12-2020","7:30 PM"),("2-12-2020","9:30 AM"),("2-12-2020","7:30 PM"),("3-12-2020","9:30 AM"),("3-12-2020","7:30 PM")]
-- for shuffling randomly and retaining that order while program rums t=seed is used 
teams_list = permutations ["BS","CM","CH","CV","CS","DS","EE","HU","MA","ME","PH","ST"]!!100
-- Zipping two at a time
zipper = zip([ teams_list!!i | i<-[0,2..length(teams_list)-1] ]) ([ teams_list!!i | i<-[1,3..length(teams_list)-1] ])
-- function to display matches
display_fixture :: Int -> IO ()
display_fixture team = putStrLn ((fst $ zipper!!team)  ++ "  " ++ "vs" ++ "  " ++ (snd $zipper!!team) ++ "    " ++ (fst $ slots!!team) ++ "        " ++ (snd $ slots!!team))
-- displaying all matches
fixture :: String -> IO ()
fixture "all" = do
    display_fixture 0
    display_fixture 1
    display_fixture 2
    display_fixture 3
    display_fixture 4
    display_fixture 5
--displaying match of specified team
fixture team = do
    if elem team teams_list then
        display_fixture((fromJust(elemIndex team teams_list)) `div` 2 )
    else 
        putStrLn "Enter Correct Team."

--Since in nextMatch time according to 24 hours is given so created new list for comparision
slots_for_comparision = [(1,9.50),(1,19.50),(2,9.50),(2,19.50),(3,9.50),(3,19.50)]

--for displaying next match given date and time
nextMatch :: Int -> Float -> IO ()
nextMatch input_date input_time = do
    let p = ([ x | x<-[0..5], (input_date,input_time)<=(slots_for_comparision!!x) ])
    if (input_time<24.00 && input_time>=0.00) == False then putStrLn "Enter Correct Time"
    else if input_date<1 || input_date>31 then putStrLn "Enter Correct Date from 1 to 31"
    else if length(p)>0 then display_fixture (p!!0)
    else putStrLn "No more matches today!!"