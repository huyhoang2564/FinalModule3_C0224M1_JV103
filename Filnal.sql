Create database PhongTro1;
use PhongTro1;
Create table HinhThucThanhToan(
HinhThucThanhToan varchar(200),
id int
);
ALTER TABLE HinhThucThanhToan
ADD PRIMARY KEY (id);
Create table PhongTro(
 MaPT int primary key not null  auto_increment,
 NameThue varchar (60) not null ,
 Phone varchar (60) ,
 DateRent date,
 id int,
 FOREIGN KEY (id) REFERENCES HinhThucThanhToan(id),
 GhiChu varchar (200)
);
INSERT INTO HinhThucThanhToan (id,HinhThucThanhToan) VALUES
(1,"theo tháng"),
(2,"theo năm"),
(3,"theo quý");
INSERT INTO PhongTro (MaPT, NameThue, Phone, DateRent,id,GhiChu) VALUES
(1, 'LVC1', '123-456-7890', '2005-04-30',1,'hop dong gia hạn 10 tháng'),
(2, 'LVC2', '124-456-7890', '2004-5-9',2,'hop dong gia hạn 1 năm'),
(3, 'LVC3', '125-456-7890', '200-1-4',1,'hop dong gia hạn 3 tháng'),
(4, 'LVC4', '126-456-7890', '2002-2-20',2,'hop dong gia hạn 2 năm'),
(5, 'LVC5', '127-456-7890', '2001-4-24',1,'đầy đủ nội thất'),
(6, 'LVC6', '128-456-7890', '2000-8-26',3,'có điều hoà'),
(7, 'LVC7', '129-456-7890', '2022-2-4',1,'hop dong gia hạn 10 tháng'),
(8, 'LVC8', '133-456-7890', '2021-4-8',1,'có tủ lạnh'),
(9, 'LVC9', '100-456-7890', '2022-2-7',3,''),
(10, 'LVC10', '111-456-7890', '2019-2-4',1,'sắp quy hạch');
Select * From PhongTro;