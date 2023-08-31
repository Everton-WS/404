from django.shortcuts import render

# bakeries_app/views.py
from django.http import HttpResponse, JsonResponse
from django.db import connection
from django.views import View

class BakeriesView(View):
    def get(self, request):
        with connection.cursor() as cursor:
            cursor.execute('SELECT * FROM Padarias')
            results = cursor.fetchall()
        
        bakeries = [{'nome': item[1], 'nota': item[2]} for item in results]
        return JsonResponse(bakeries, safe=False)

class WelcomeView(View):
    def get(self, request):
        result = "Bem-vindo ao sistema de avaliação de bolinhos de carne das padarias Blumenauenses!"
        result += "<br>Segue a lista (em JSON) do que já temos cadastrado no DB<br><br><br>"

        with connection.cursor() as cursor:
            cursor.execute('SELECT * FROM Padarias')
            results = cursor.fetchall()
        
        bakeries_json = [{'nome': item[1], 'nota': item[2]} for item in results]
        result += str(bakeries_json)
        return HttpResponse(result)

