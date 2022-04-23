Во рамки на апликацијата се чуваат следните 
податоци за книгите: id (Long), name (String), category (enum), 
author (Author), availableCopies (Integer). 

Категоријата на книгата може да биде: NOVEL, THRILER, HISTORY, FANTASY, BIOGRAPHY, CLASSICS, DRAMA. 

За секој автор пак се чуваат податоците: id (Long), name (String), surname (String), country (Country). 
За секоја земја се чуваат податоците: id (Long), name (String), continent (String).






Product -->Book (Nesto od product nesto od Shoping cart)
Category ---> Author --> prodolzuva so manufac...
manufacturer -->country ---> prodolzuva so manufa...
ShoppingCart -->Mark As Taken
