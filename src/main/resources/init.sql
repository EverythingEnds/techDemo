do $$
    begin
        for r in 1..200 loop
                insert into address(id, index, region, city, street, house, apartments) values(r, 'indexValue' || r, 'regionValue' || r, 'cityValue' || r, 'streetValue' || r, 'h' || r, 'app' || r);
            end loop;
        for r in 1..150 loop
                insert into employee(id, surname, firstname, patronymic, birthday) values(r, 'surname' || r, 'firstname' || r, 'patronymic' || r, '1988-01-01');
            end loop;
        for r in 1..50 loop
                insert into agency(id, fullname, shortname, inn, ogrn, postal_address_id, legal_address_id, director_id) values(r, 'agency full name' || r, 'agName' || r, '2131235435_'|| r, '1243125a12Ga13_'|| r, r, r+1, r);
            end loop;
        for r in 1..100 loop
                insert into branch (id, name, postal_address_id, chief_id, agency_id) values (r, 'branchName' || r, r+50, r+50, floor(random()* (50-1 + 1) + 1));
            end loop;
    end;
$$

