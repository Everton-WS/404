const express = require('express');
const mysql = require('mysql');

const app = express();


const connection = mysql.createConnection({
    host: process.env.NODE_DB_HOST,
    port: process.env.NODE_DB_PORT,
    user: process.env.NODE_DB_USER,
    password: process.env.NODE_DB_PASS,
    database: process.env.NODE_DB_SCHEMA
  });



connection.connect();

app.get('/bakeries', function(req, res) {
   connection.query('SELECT * FROM Padarias', function (error, results) {
      if (error) { 
        console.log(error)
         throw error
   };

   res.send(results.map(item => ({ nome: item.Nome, nota: item.NotaBolinho })));

  });
});

app.get('/', function(req, res) {
  var result = "bem vindo ao sistema de avaliação de bolinhos de carne das padarias Blumenauenses!";
  result += "<br> segue a lista (em json) do que já temos cadastrado no DB     <br><br><br>";

  connection.query('SELECT * FROM Padarias', function (error, results) {
    if (error) { 
      console.log(error)
       throw error
  };

  var json = JSON.stringify(results.map(item => ({ nome: item.Nome, nota: item.NotaBolinho })));
  res.send(result + json);

 });
});

app.listen(3000, function() {
    console.log('Listening on port 3000');

})