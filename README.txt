Q1 ————————————————————————
Output: no output on this step
Common: easy to be added

Q2 ————————————————————————
Output: no output on this step
Common: remember to check if the paper does not exist (null)

Q3 ————————————————————————
Output:
Title:      Triangles and Squares: A preschool analysis
Authors:    Bobby, Kelly, Jesse, Peter 
Keywords:   graphs, squares, triangles 
Conference: CCCG

Title:      Useless graphs and how to draw them
Authors:    Cindy, Dave, Brett, Shelly 
Keywords:   drawing, graphs, useless 
Conference: Graph Drawing Conference

Title:      Neural Nets: Say Hi to Our Future Machine Overlords
Authors:    Mark, Luke, Peter, Paul 
Keywords:   apocalypse, borg, end of humanity 
Conference: Skynet conference

Title:      How to survive first year comp sci
Authors:    Jesse, Dave, Julie, Shelly 
Keywords:   procrastinating, java, compsci 
Conference: LATIN

Common: be careful on the ArrayList - authors and keywords, using FOR-EACH loop to search


Q4 ————————————————————————
Output: 
Title:      Triangles and Squares: A preschool analysis
Authors:    Bobby, Kelly, Jesse, Peter 
Keywords:   graphs, squares, triangles 
Conference: CCCG

Title:      Useless graphs and how to draw them
Authors:    Cindy, Dave, Brett, Shelly 
Keywords:   drawing, graphs, useless 
Conference: Graph Drawing Conference

Title:      Neural Nets: Say Hi to Our Future Machine Overlords
Authors:    Mark, Luke, Peter, Paul 
Keywords:   apocalypse, borg, end of humanity 
Conference: Skynet conference

Title:      How to survive first year comp sci
Authors:    Jesse, Dave, Julie, Shelly 
Keywords:   procrastinating, java, compsci 
Conference: LATIN

Common: 
Needed to add the paper into the arrayList (output is arrayList)
Created a local ArrayList<ResearchPaper> papers variable
When we found a paper which matched the author and conference, we added this paper into the papers arrayList
Return the ArrayList 


Q5 ————————————————————————
Output:
/Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=50739:/Applications/IntelliJ IDEA.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath /Users/mia/Desktop/a5/out/production/a5 assign5.PaperDBModel
Here are the Research Papers in our model right now: 
Title:      Triangles and Squares: A preschool analysis
Authors:    Bobby, Kelly, Jesse, Peter 
Keywords:   graphs, squares, triangles 
Conference: CCCG

Title:      Useless graphs and how to draw them
Authors:    Cindy, Dave, Brett, Shelly 
Keywords:   drawing, graphs, useless 
Conference: Graph Drawing Conference

Title:      Neural Nets: Say Hi to Our Future Machine Overlords
Authors:    Mark, Luke, Peter, Paul 
Keywords:   apocalypse, borg, end of humanity 
Conference: Skynet conference

Title:      How to survive first year comp sci
Authors:    Jesse, Dave, Julie, Shelly 
Keywords:   procrastinating, java, compsci 
Conference: LATIN

Let's Test getPapersByAuthorAndConference
Author Cindy's papers or papers by Conference Skynet conference: 
[Title:      Useless graphs and how to draw them
Authors:    Cindy, Dave, Brett, Shelly 
Keywords:   drawing, graphs, useless 
Conference: Graph Drawing Conference
, Title:      Neural Nets: Say Hi to Our Future Machine Overlords
Authors:    Mark, Luke, Peter, Paul 
Keywords:   apocalypse, borg, end of humanity 
Conference: Skynet conference
]
Author Cindy's papers under Conference CU: 
[Title:      Useless graphs and how to draw them
Authors:    Cindy, Dave, Brett, Shelly 
Keywords:   drawing, graphs, useless 
Conference: Graph Drawing Conference
]
======================================================
Let's Test getPapersByAuthors
Author Cindy and Bobby wrote papers 
---------------------------------------Cindy
---------------------------------------Bobby
[Title:      Useless graphs and how to draw them
Authors:    Cindy, Dave, Brett, Shelly 
Keywords:   drawing, graphs, useless 
Conference: Graph Drawing Conference
, Title:      Triangles and Squares: A preschool analysis
Authors:    Bobby, Kelly, Jesse, Peter 
Keywords:   graphs, squares, triangles 
Conference: CCCG
]
Author Cindy and Mia wrote papers 
---------------------------------------Cindy
---------------------------------------Mia
[Title:      Useless graphs and how to draw them
Authors:    Cindy, Dave, Brett, Shelly 
Keywords:   drawing, graphs, useless 
Conference: Graph Drawing Conference
]
======================================================
Let's Test RemoveResearchPaper
Remove <How to survive first year comp sci>
Now search paper <How to survive first year comp sci>: 
null
======================================================
Let's Test AddResearchPaper
Add paper <How to survive first year comp sci> back 
Now search paper <whatever>: 
Title:      whatever
Authors:    123, asd 
Keywords:   xxx, zzz 
Conference: who know

======================================================
Let's Test getResearchPaper
Get <Useless graphs and how to draw them>
Title:      Useless graphs and how to draw them
Authors:    Cindy, Dave, Brett, Shelly 
Keywords:   drawing, graphs, useless 
Conference: Graph Drawing Conference

Get <I love COMP>
null
======================================================
Let's Test getPapersByAuthor
Get Cindy's paper: 
[Title:      Useless graphs and how to draw them
Authors:    Cindy, Dave, Brett, Shelly 
Keywords:   drawing, graphs, useless 
Conference: Graph Drawing Conference
]
Get Mia's paper: 
null
======================================================
Let's Test getPapersByConference
Get papers under conference Skynet conference: 
[Title:      Neural Nets: Say Hi to Our Future Machine Overlords
Authors:    Mark, Luke, Peter, Paul 
Keywords:   apocalypse, borg, end of humanity 
Conference: Skynet conference
]
Get papers under conference CU: 
null
======================================================
Let's Test getPapersByKeyword
Papers with key word apocalypse: 
[Title:      Neural Nets: Say Hi to Our Future Machine Overlords
Authors:    Mark, Luke, Peter, Paul 
Keywords:   apocalypse, borg, end of humanity 
Conference: Skynet conference
]
Papers with key word fun: 
null

Process finished with exit code 0


Common: 
remember to text existing papers and non existing paper / authors etc.
When search by authors / conferences etc, need to check if this category exist