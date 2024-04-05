s, ss = input(), ''
i = 0
while i < len(s):
   dem = 1
   k=i+1
   if k<len(s):
      while s[i]==s[k]:
         dem+=1
         k+=1
   ss+=s[i]+str(dem)
   i=k
print(ss)
