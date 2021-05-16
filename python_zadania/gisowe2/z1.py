# -*- coding: utf-8 -*-
"""
Created on Tue Jun 18 15:07:04 2019

@author: Stadnicki Mateusz
"""

from osgeo import ogr


otworz_woj = ogr.Open("wojewodztwa.shp")
warstwa = otworz_woj.GetLayer()

otworz_jeziora = ogr.Open("jeziora.shp")
warstwa1 = otworz_jeziora.GetLayer()


for i, feature in enumerate(warstwa,1):
    
    print(i,feature.GetField("jpt_nazwa_"))

print("")    
print("Wybierz z listy numer wojewodztwa a następnie poczekaj na wynik:")
    
numer_woj = int(input("Wprowadz tutaj numer wojewodztwa: "))-1

print("Poczekaj na wynik! ")
print("")

wojewodztwo = warstwa.GetFeature(numer_woj)
sprawdz_geom = wojewodztwo.GetGeometryRef()

i=0
for feature in warstwa1:
    jezioro_geom = feature.GetGeometryRef()
    nazwa_jeziora = feature.GetField("NAZ_KATAL")
    granice = jezioro_geom.Intersection(sprawdz_geom)
    
    if nazwa_jeziora is not None and granice.GetArea() > 100*10:
            i +=1
            print(str(nazwa_jeziora))


print('jezior spelniajacych podane warunki jest: ', i)

