from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='index'),
    path('get-repos/', views.get_repos, name='get_repos'),
]
