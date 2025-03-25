import requests
from django.http import JsonResponse
from django.shortcuts import render

def get_repos(request):
    username = request.GET.get('username', '')
    if not username:
        return JsonResponse({'error': 'Username is required.'}, status=400)

    url = f"https://api.github.com/users/{username}/repos"
    response = requests.get(url)  # gửi get request đến API 

    if response.status_code != 200:
        if response.status_code == 404:  # tên người dùng không hợp lệ
            # TODO url = f"https://api.github.com/users/{username[:-i]}/repos" for i in range(len(username))
            return JsonResponse({'error': 'error in username'}, status=response.status_code)
        elif response.status_code in (403, 429, ):  # giới hạn tần suất
            # TODO headers = {'Authorization': 'token YOUR_PERSONAL_ACCESS_TOKEN'} or apply proxy
            return JsonResponse({'error': 'API rate limit exceeded'}, status=response.status_code)
        return JsonResponse({'error': 'Failed to fetch repositories.'}, status=response.status_code)

    repos = response.json()
    repo_list = [{'name': repo['name'], 'url': repo['html_url']} for repo in repos]

    return JsonResponse({'repositories': repo_list})

def index(request):
    return render(request, 'repos/index.html')
