# -*- coding: utf-8 -*-
"""
Created on Tue Jun 18 15:07:04 2019

@author: Stadnicki Mateusz
"""


from osgeo import ogr, gdal
import math


min_width= math.inf
max_width = -math.inf

dem = gdal.Open("lubelskie.tif")
band = dem.GetRasterBand(1)
miasta = ogr.Open("miasta.shp")



open_gt = dem.GetGeoTransform()
transform = gdal.InvGeoTransform(open_gt)


array = band.ReadAsArray()
warstwa = miasta.GetLayer()

for lokalizacje in warstwa:
    geom = lokalizacje.GetGeometryRef()
    
    x = geom.GetX()
    y = geom.GetY()
    
    kolumna, wiersz = gdal.ApplyGeoTransform(transform, x, y)
    kolumna = int(kolumna)
    wiersz = int(wiersz)
    wysokosc = array[wiersz, kolumna]

    if wysokosc > max_width:
       nazwa = lokalizacje.GetField("name")
        
    if wysokosc < min_width:
        min_width = wysokosc
        nazwaa = lokalizacje.GetField("name")
        

print("Miasto najwyzej: ", wysokosc, nazwa)
print("Miasto najnizej: ", min_width, nazwaa)


