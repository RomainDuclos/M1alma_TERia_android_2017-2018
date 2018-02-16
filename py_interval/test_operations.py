
# coding: utf-8

# In[25]:


from interval import interval, inf, imath
a = interval[5.0,5.1]
b = interval[1.0,2.0]
c = interval[0.36,0.899]
d = interval[-1.0,1.0]
print("a = " , a)
print("b = " , b)
print("c = " , c)
print("d = " , d)

print("a+b = ", a + b)
print("c inter d = ", c & d)
print("a*c = ", a * c)
print("sin(a) = " ,imath.sin(a))
print("cos(b) = " , imath.cos(b))
print("midpoint(d) =" , d.midpoint)

