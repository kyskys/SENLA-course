-- Задание: 1
-- Найдите номер модели, скорость и размер жесткого диска для всех ПК стоимостью менее 500 дол. Вывести: model, speed и hd

Select model, speed, hd from pc where price <500

-- Задание: 2
-- Найдите производителей принтеров. Вывести: maker

select maker from product where type="Printer"

-- Задание: 3
-- Найдите номер модели, объем памяти и размеры экранов ПК-блокнотов, цена которых превышает 1000 дол.

select model, ram, screen from laptop where price>1000

-- Задание: 4
-- Найдите все записи таблицы Printer для цветных принтеров.

select * from printer where color=”y”

-- Задание: 5
-- Найдите номер модели, скорость и размер жесткого диска ПК, имеющих 12x или 24x CD и цену менее 600 дол.

select model, speed, hd from pc where (in(12,24) and price<600)

-- Задание: 6
-- Укажите производителя и скорость для тех ПК-блокнотов, которые имеют жесткий диск объемом не менее 10 Гбайт.

select maker, speed from laptop inner join product on laptop.model=product.model where hd>=10

-- Задание: 7
-- Найдите номера моделей и цены всех продуктов (любого типа), выпущенных производителем B (латинская буква).

select product.model,coalesce(laptop.price,pc.price,printer.price) as price 
from product 
left join laptop 
on product.model=laptop.model 
left join pc 
on product.model=pc.model 
left join printer o
n product.model=printer.model 
where maker="B"

-- Задание: 8
-- Найдите производителя, выпускающего ПК, но не ПК-блокноты.

select distinct maker 
from product 
where type="PC" 
and maker not in
(select distinct maker from product where type="Laptop")

-- Задание: 9
-- Найдите производителей ПК с процессором не менее 450 Мгц. Вывести: Maker

select distinct maker from product where model in(select model from pc where speed>=450)

-- Задание: 10
-- Найдите принтеры, имеющие самую высокую цену. Вывести: model, price

select model, max(price) from printer

-- Задание: 11
-- Найдите среднюю скорость ПК.

select avg(speed) from pc

-- Задание: 12
-- Найдите среднюю скорость ПК-блокнотов, цена которых превышает 1000 дол.

select avg(speed) from laptop where price>1000

-- Задание: 13
-- Найдите среднюю скорость ПК, выпущенных производителем A.

select avg(speed) from pc where model in (select model from product where maker=”A”)

-- Задание: 14
-- Для каждого значения скорости найдите среднюю стоимость ПК с такой же скоростью процессора. Вывести: скорость, средняя цена

select avg(price),speed from pc group by speed

-- Задание: 15
-- Найдите размеры жестких дисков, совпадающих у двух и более PC. Вывести: HD

select hd from pc group by hd having count(hd)>=2

-- Задание: 16
-- Найдите пары моделей PC, имеющих одинаковые скорость и RAM. В результате каждая пара указывается 
-- только один раз, т.е. (i,j), но не (j,i), Порядок вывода: модель с большим номером, модель с меньшим номером, скорость и RAM

select ordered.code,unordered.code,unordered.speed,unordered.ram from 
(select code,speed,ram from pc order by code) as ordered
join pc as unordered
on ordered.code>unordered.code 
and ordered.ram=unordered.ram 
and ordered.speed=unordered.speed

-- Задание: 17
-- Найдите модели ПК-блокнотов, скорость которых меньше скорости любого из ПК. 
Вывести: type, model, speed

select distinct model,speed from laptop where speed<(select min(speed) from pc)

-- Задание: 18
-- Найдите производителей самых дешевых цветных принтеров. Вывести: maker, price

select maker,min_price from product,
(select model, price as min_price from printer where 
price=(select min(price) from printer)) as prin where 
product.model=prin.model

-- Задание: 19
-- Для каждого производителя найдите средний размер экрана выпускаемых им ПК-блокнотов. Вывести: maker, средний размер экрана.

select avg(screen),prodlap.maker from laptop, 
(select distinct model as prodm, maker from product 
where product.type="Laptop") as prodlap where 
model in (prodm) group by model

-- Задание: 20
-- Найдите производителей, выпускающих по меньшей мере три различных модели ПК. Вывести: Maker, число моделей

select  prod.maker,pc_count as count 
from product as prod 
left join (select model as pc_model, count(model) as pc_count
 from pc group by model having count(model)>=3) as pc_table 
on pc_model = prod.model 
where pc_count is not null

-- Задание: 21
-- Найдите максимальную цену ПК, выпускаемых каждым производителем. Вывести: maker, максимальная цена.

select maker, max_price as price
from product as prod
left join 
(select model as pc_model, max(price) as max_price
from pc 
group by model) as pc_table
on prod.model=pc_model where type=”PC”

-- Задание: 22
-- Для каждого значения скорости ПК, превышающего 600 МГц, определите среднюю цену ПК с такой же скоростью. Вывести: speed, средняя цена.

select speed, avg(price) as price
from pc
where speed>600 group by speed

-- Задание: 23
-- Найдите производителей, которые производили бы как ПК со скоростью не менее 750 МГц, так и ПК-блокноты со скоростью не менее 750 МГц. Вывести: Maker

select maker from product as prod
where prod.model in (select distinct model from pc where speed>=750)
or prod.model in(select distinct model from laptop where speed>=750)
group by maker having count(maker)=2

-- Задание: 24
-- Перечислите номера моделей любых типов, имеющих самую высокую цену по всей имеющейся в базе данных продукции.

select prices.model from (select model, price from pc
union select model, price from printer
union select model, price from laptop) as prices
where price = 
(select greatest(
(select max(price) from pc),
(select max(price) from laptop),
(select max(price) from printer)))

-- Задание: 25
-- Найдите производителей принтеров, которые производят ПК с наименьшим объемом RAM и с самым быстрым процессором 
-- среди всех ПК, имеющих наименьший объем RAM. Вывести: Maker

select maker from product inner join pc 
on product.model=pc.model where( 
ram = (select min(ram) from pc)  and 
speed = (select max(speed) from 
(select min(ram) from pc) as min_ram_pc) )
and type="PC" 
and maker in
(select maker from product where type="PC" or type ="Printer" group by maker having count(*)=2)
