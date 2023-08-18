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

app.listen(3000, function() {
    console.log('Listening on port 3000');

})