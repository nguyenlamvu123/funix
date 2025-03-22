import requests
from django.http import JsonResponse
from django.shortcuts import render

def get_repos(request):
    username = request.GET.get('username', '')
    if not username:
        return JsonResponse({'error': 'Username is required.'}, status=400)

    url = f"https://api.github.com/users/{username}/repos"
    response = requests.get(url)

    if response.status_code != 200:
        return JsonResponse({'error': 'Failed to fetch repositories.'}, status=response.status_code)

    repos = response.json()
    repo_list = [{'name': repo['name'], 'url': repo['html_url']} for repo in repos]

    return JsonResponse({'repositories': repo_list})

def index(request):
    return render(request, 'repos/index.html')
