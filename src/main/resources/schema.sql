create table Card_Details (
	 card_no varchar(20) primary key
 	,card_typ varchar(250)
	,card_exp date
	,sec_cd int
);


create table User_Card_Details (
	 id int AUTO_INCREMENT primary key
	,username varchar(50)
	,card_no varchar(20) 
	,FOREIGN KEY (card_no)
        REFERENCES Card_Details(card_no)
        ON UPDATE CASCADE
);


create table Card_Transaction (
	 card_no varchar(20)
	,tran_dt date
	,tran_amt decimal(20,4)
	,tran_place varchar(200)
	,tran_st varchar(10)
	,FOREIGN KEY (card_no)
        REFERENCES Card_Details(card_no)
        ON UPDATE CASCADE
);
