CREATE or REPLACE PROCEDURE read_items (out_items_cur OUT sys_refcursor)
AS
BEGIN
OPEN out_items_cur FOR 'select * from items';
END;
/

CREATE OR REPLACE PROCEDURE read_name (item_pk in int, item_name out varchar)
AS
BEGIN
select name into item_name from items where item_id = item_pk;
END;
/
