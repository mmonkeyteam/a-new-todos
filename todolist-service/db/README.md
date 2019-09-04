todolist db v1

1) **Create a mysql database using docker**
- docker run --name test-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d -p 3306:3306 mysql
- waiting few seconds to complete the db creation.

2) **Test the connection**
- for example using an sql client. (Suggested: Dbeaver)

3) **Next step**
- docker image to create database with tables and configuration data.
