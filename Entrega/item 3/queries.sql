Query C/1

T�tulo: The average, the minimum, the maximum, and the standard deviation of the number of applications per trip.

Consulta: select max(t.applicationsFor.size), min(t.applicationsFor.size), avg(t.applicationsFor.size) , stddev(t.applicationsFor.size) from Trip t;

Descripci�n: En esta consulta estamos usando las funciones max, min, avg y stddev para calcular el m�ximo n�mero de solicitudes que tienen las excursiones, el m�nimo n�mero de solicitudes que tienen las excursiones, la media de las solicitudes que tienen las excursiones y su desviaci�n est�ndar. En la clase Trip hay una colecci�n de solicitudes y desde esa clase cogemos el n�mero de solicitudes que tienen las excursiones y as� poder hacer el m�ximo, el m�nimo, la media y la desviaci�n t�pica. Esta consulta te devuelve un solo objeto con los datos explicados.

Resultado: 

1 object selected
[3, 0, 1.4, 1.0198]

Query C/2

T�tulo: The average, the minimum, the maximum, and the standard deviation of the number of trips managed per manager.

Consulta: select max(m.trips.size), min(m.trips.size), avg(m.trips.size), stddev(m.trips.size) from Manager m;

Descripci�n: En esta consulta estamos usando las funciones max, min, avg y stddev para calcular el m�ximo n�mero de excursiones que maneja un manager, el m�nimo n�mero de excursiones que maneja un manager, la media de las excursiones que maneja un manager y su desviaci�n est�ndar. En la clase Manager hay una colecci�n de excursiones y desde esa clase cogemos el n�mero de excursiones que tienen cada uno de los managers y as� poder hacer el m�ximo, el m�nimo, la media y la desviaci�n est�ndar. Esta consulta te devuelve un solo objeto con los datos explicados.

Resultado: 

1 object selected
[2, 0, 1.0, 0.6325]

Query C/3

T�tulo: The average, the minimum, the maximum, and the standard deviation of the price of the trips.

Consulta: select min(t.price), max(t.price), avg(t.price), stddev(t.price) from Trip t;

Descripci�n: En esta consulta estamos usando las funciones max, min, avg y stddev para calcular el precio m�ximo de las excursiones, el precio m�nimo, la media de los precios y su desviaci�n est�ndar. En la clase Trip tenemos un atributo precio y desde esa clase cogemos el precio que tiene cada una de las excursiones y as� poder hacer el m�ximo, el m�nimo, la media y la desviaci�n est�ndar. Esta consulta te devuelve un solo objeto con los datos explicados.

Resultado: 

1 object selected
[12.3, 55.5, 33.56, 15.347390657698135]

Query C/4

T�tulo: The average, the minimum, the maximum, and the standard deviation of the number trips guided per ranger.

Consulta: select avg(r.trips.size),min(r.trips.size),max(r.trips.size), stddev(r.trips.size) from Ranger r;

Descripci�n: En esta consulta estamos usando las funciones max, min, avg y stddev para calcular el n�mero de trips m�ximo, m�nimo y la desviaci�n est�ndar que son guiados por los Rangers. En la clase Ranger tenemos un atributo que es la lista de trips que gu�an y en funci�n del tama�o de dicha lista (puesto que el tama�o depende de la cantidad de trips que est� guiando dicho Ranger) realizamos el m�ximo, el m�nimo, la media y la desviaci�n est�ndar. Esta consulta te devuelve un solo objeto con los datos explicados.

Resultado: 

1 object selected
[1.0, 0, 2, 0.6325]

Query C/5

T�tulo: The ratio of applications with status �PENDING�.

Consulta: select (select count(a) from ApplicationFor a where a.status='PENDING') *1.0 / count(a) from ApplicationFor a;

Descripci�n: Esta query consta de dos consultas, la primera cuenta el n�mero de applicationFor que tienen como estado pendiente y se multiplica por 1.0 para que el resultado de la divisi�n sea un double, posteriormente a la multiplicaci�n se hace una divisi�n entre el n�mero total de ApplicationFor.

Resultado: 

1 object selected
0.28571

Query C/6

T�tulo: The ratio of applications with status �DUE�.

Consulta: select (select count(a) from ApplicationFor a where a.status='DUE') *1.0 / count(a) from ApplicationFor a;

Descripci�n: Esta query consta de dos consultas, la primera cuenta el n�mero de applicationFor que tienen como estado debido y se multiplica por 1.0 para que el resultado de la divisi�n sea un double, posteriormente a la multiplicaci�n se hace una divisi�n entre el n�mero total de ApplicationFor.

Resultado: 

1 object selected
0.14286

Query C/7

T�tulo: The ratio of applications with status �ACCEPTED�.

Consulta: select (select count(c) from ApplicationFor c where c.status='ACCEPTED') *1.0 / count(r) from ApplicationFor r;

Descripci�n: Esta query consta de dos consultas, la primera cuenta el n�mero de applicationFor que tienen como estado aceptado y se multiplica por 1.0 para que el resultado de la divisi�n sea un double, posteriormente a la multiplicaci�n se hace una divisi�n entre el n�mero total de ApplicationFor.

Resultado: 

1 object selected
0.28571

Query C/8

T�tulo: The ratio of applications with status �CANCELLED�.

Consulta: select (select count(c) from ApplicationFor c where c.status='CANCELLED') *1.0 / count(r) from ApplicationFor r;

Descripci�n: Esta query consta de dos consultas, la primera cuenta el n�mero de applicationFor que tienen como estado cancelado y se multiplica por 1.0 para que el resultado de la divisi�n sea un double, posteriormente a la multiplicaci�n se hace una divisi�n entre el n�mero total de ApplicationFor.

Resultado: 

1 object selected
0.14286

Query C/9

T�tulo: The ratio of trips that have been cancelled versus the total number of trips that have been organised.

Consulta: select (select count(c) from Trip c where c.cancelled=true) * 1.0 / count(r) from Trip r where r.publicationDate is not null;

Descripci�n: Esta query consta de dos consultas, la primera consulta lo que hace es contar el n�mero de trips que han sido canceladas y se multiplica por 1.0 para que posteriormente el resultado sea un double, luego de la multiplicaci�n se hace la segunda consulta que lo que hace es contar el n�mero de trips que han sido organizadas.

Resultado: 

1 object selected
0.75

Query C/10

T�tulo: The listing of trips that have got at least 10% more applications than the av- erage, ordered by number of applications.

Consulta: select t from Trip t where t.applicationsFor.size > 1.1*(select avg(t.applicationsFor.size) from Trip t) order by t.applicationsFor.size;

Descripci�n: Esta consulta nos muestra las Trips que tiene al menos un 10% m�s ApplicationsFor de la media de ApplicationsFor que tiene cada Trip y todo ordenado por el n�mero de ApplicationsFor. Por tanto est� compuesta de dos consultas, una que nos devuelve la media de ApplicationsFor por Trip, lo que nos devuelve lo multiplicamos por 1.1 para hacerle el 10% y consultamos la Trips que tienen m�s applicationsFor del n�mero que nos devuelve la consulta anterior.  

Resultado: 

2 objects selected
domain.Trip{id=6206, version=0}
	domain.DomainEntity::id: int = 6206
	domain.DomainEntity::version: int = 0
	domain.Trip::ticker: java.lang.String = "170112-WWWW"
	domain.Trip::title: java.lang.String = "title 1"
	domain.Trip::description: java.lang.String = "description 1"
	domain.Trip::price: double = 12.3
	domain.Trip::requirementsExplorers: java.util.Collection = ["requirementsExplorers 1", "requirementsExplorers 2"]
	domain.Trip::publicationDate: java.util.Date = <<2017-02-02 22:45:00.0>>
	domain.Trip::startDate: java.util.Date = <<2017-02-03>>
	domain.Trip::finishDate: java.util.Date = <<2017-02-04>>
	domain.Trip::reasonWhy: java.lang.String = "reasonWhy 1"
	domain.Trip::cancelled: boolean = true
	domain.Trip::ranger: domain.Ranger = domain.Ranger{id=6139, version=1}
	domain.Trip::manager: domain.Manager = domain.Manager{id=6168, version=0}
	domain.Trip::classes: java.util.Collection = [domain.SurvivalClass{id=6231, version=0}]
	domain.Trip::stories: java.util.Collection = [domain.Story{id=6236, version=0}]
	domain.Trip::applicationsFor: java.util.Collection = [domain.ApplicationFor{id=6241, version=0}, domain.ApplicationFor{
id=6247, version=0}]
	domain.Trip::auditRecords: java.util.Collection = [domain.AuditRecord{id=6221, version=0}]
	domain.Trip::notes: java.util.Collection = [domain.Note{id=6216, version=0}]
	domain.Trip::categories: java.util.Collection = [domain.Category{id=6162, version=0}]
	domain.Trip::sponsorships: java.util.Collection = [domain.Sponsorship{id=6226, version=0}]
	domain.Trip::stages: java.util.Collection = [domain.Stage{id=6207, version=0}]
	domain.Trip::legalText: domain.LegalText = domain.LegalText{id=6152, version=0}
	domain.Trip::tags: java.util.Collection = [domain.Tag{id=6132, version=0}]
domain.Trip{id=6214, version=0}
	domain.DomainEntity::id: int = 6214
	domain.DomainEntity::version: int = 0
	domain.Trip::ticker: java.lang.String = "150112-DDDD"
	domain.Trip::title: java.lang.String = "title 5"
	domain.Trip::description: java.lang.String = "description 5"
	domain.Trip::price: double = 55.5
	domain.Trip::requirementsExplorers: java.util.Collection = ["requirementsExplorers 8", "requirementsExplorers 9"]
	domain.Trip::publicationDate: java.util.Date = null
	domain.Trip::startDate: java.util.Date = <<2014-02-21>>
	domain.Trip::finishDate: java.util.Date = <<2015-08-04>>
	domain.Trip::reasonWhy: java.lang.String = "reasonWhy 5"
	domain.Trip::cancelled: boolean = false
	domain.Trip::ranger: domain.Ranger = domain.Ranger{id=6139, version=1}
	domain.Trip::manager: domain.Manager = domain.Manager{id=6172, version=0}
	domain.Trip::classes: java.util.Collection = [domain.SurvivalClass{id=6235, version=0}]
	domain.Trip::stories: java.util.Collection = [domain.Story{id=6240, version=0}]
	domain.Trip::applicationsFor: java.util.Collection = [domain.ApplicationFor{id=6244, version=0}, domain.ApplicationFor{
id=6245, version=0}, domain.ApplicationFor{id=6246, version=0}]
	domain.Trip::auditRecords: java.util.Collection = [domain.AuditRecord{id=6225, version=0}]
	domain.Trip::notes: java.util.Collection = []
	domain.Trip::categories: java.util.Collection = [domain.Category{id=6166, version=0}]
	domain.Trip::sponsorships: java.util.Collection = [domain.Sponsorship{id=6230, version=0}]
	domain.Trip::stages: java.util.Collection = [domain.Stage{id=6215, version=0}]
	domain.Trip::legalText: domain.LegalText = domain.LegalText{id=6152, version=0}
	domain.Trip::tags: java.util.Collection = [domain.Tag{id=6136, version=0}, domain.Tag{id=6132, version=0}]

Query C/11

T�tulo: A table with the number of times that each legal text�s been referenced.

Consulta: select count(t) from Trip t group by t.legalText;

Descripci�n: Esta query nos devuelve el n�mero de veces que un LegalText ha sido referenciado. Para ello contamos el n�mero de Trip que tienen ese LegalText, esto lo hacemos agrupando las Trip por los legalTexts. 

Resultado: 

4 objects selected
2
1
1
1

Query B/1

T�tulo: The minimum, the maximum, the average, and the standard deviation of the number of notes per trip.

Consulta: select min(t.notes.size), max(t.notes.size), avg(t.notes.size), stddev(t.notes.size) from Trip t;

Descripci�n: En esta consulta devolvemos el m�nimo, m�ximo, media y desviaci�n t�pica de las notas que tienen las Trips. Para ello usamos las funciones definidas en jpql (min, max, avg y stddev). Esas operaciones se las aplicamos al n�mero de notes que tiene cada Trip.

Resultado: 

1 object selected
[0, 2, 1.0, 0.6325]

Query B/2

T�tulo: The minimum, the maximum, the average, and the standard deviation of the number of audit records per trip.

Consulta: select min(t.auditRecords.size),max(t.auditRecords.size),avg(t.auditRecords.size), stddev(t.auditRecords.size) from Trip t;

Descripci�n: La consulta selecciona el n�mero m�nimo, m�ximo, la media y la desviaci�n est�ndar de auditRecords que tiene un Trip de entre todos los Trips.

Resultado: 

1 object selected
[0, 2, 1.0, 0.6325]

Query B/3

T�tulo: The ratio of trips with an audit record.

Consulta: select count(r)/(select count(t) from Trip t)*1.0 from Trip r where r.auditRecords.size>0;

Descripci�n: La consulta selecciona el n�mero de Trips que tengan auditRecords y los divide entre el n�mero total de trips.

Resultado: 

1 object selected
0.8

Query B/4

T�tulo: The ratio of rangers who have registered their curricula.

Consulta: select count(r)/(select count(s) from Ranger s)*1.0 from Ranger r where r.curricula!=null;

Descripci�n: La consulta selecciona el n�mero de Rangers que tengan curricula y los divide entre el n�mero total de Rangers.

Resultado: 

1 object selected
0.6

Query B/5

T�tulo: The ratio of rangers whose curriculum�s been endorsed.

Consulta: select (select count(c) from Ranger r join r.curricula c where c.endorserRecords.size>0)*1.0/count(c) from Curricula c;

Descripci�n: Esta consulta est� compuesta de dos consultas la primera cuenta todas los ranger que tengan en su curricula alg�n EndorseRecord y en la otra se calcula el n�mero total de Curriculas que hay que a su vez equivale al n�mero de Ranger. Despu�s �stos se dividen y as� se calcula el ratio. Se ha multiplicado el dividendo * 1.0 para que el resultado sea un double.

Resultado: 

1 object selected
0.6

Query B/6

T�tulo: The ratio of suspicious managers.

Consulta: select (select count(m1) from Manager m1 where m1.suspicious=false)*1.0/count(m) from Manager m ;

Descripci�n: Esta consulta est� compuesta por dos consultas, la que hace referencia al objeto m te cuenta el n�mero total de Manager y la otra que hace referencia al objeto m1 te cuenta el n�mero de Manager que son sospechosos. Despu�s se calcula el ratio de esta forma: m1*1.0/m. Se multiplica por 1.0 para que el dividendo sea double y al hacer la divisi�n tambi�n lo sea.

Resultado: 

1 object selected
0.6

Query B/7

T�tulo: The ratio of suspicious rangers.

Consulta: select (select count(r1) from Ranger r1 where r1.suspicious=false)*1.0/count(r) from Ranger r ;

Descripci�n: Esta consulta est� compuesta por dos consultas, la que hace referencia al objeto r te cuenta el n�mero total de Ranger y la otra que hace referencia al objeto r1 te cuenta el n�mero de Ranger que son sospechosos. Despu�s se calcula el ratio de esta forma r1*1.0/r. Se multiplica por 1.0 para que el dividendo sea double y al hacer la divisi�n tambi�n lo sea.

Resultado: 

1 object selected
0.4
