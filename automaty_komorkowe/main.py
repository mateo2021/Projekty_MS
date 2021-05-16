from piasek import *
import sys
import pygame



def rysuj_piasek(siatka):
    for i in range(siatka.org_y):
        for j in range(siatka.org_x):
            if siatka.siatka[i][j+1] == 'O':
               pygame.draw.rect(OKNOGRY, (253, 228, 86), pygame.Rect((j * WIELKOSC,i * WIELKOSC), (1 * WIELKOSC,1 * WIELKOSC)))
            if siatka.siatka[i][j+1] == 'X':
                pygame.draw.rect(OKNOGRY, (255, 255, 255), pygame.Rect((j * WIELKOSC,i * WIELKOSC), (1 * WIELKOSC,1 * WIELKOSC)))
            if siatka.siatka[i][j+1] == 'W':
                pygame.draw.rect(OKNOGRY, (0, 0, 0), pygame.Rect((j * WIELKOSC,i * WIELKOSC), (1 * WIELKOSC,1 * WIELKOSC)))

try:
    sciezka = sys.argv[1]
except:
    print("Nie podano nazwy pliku")
    sys.exit()

WIELKOSC = 4
SZYBKOSC = 5
CZESTOTLIWOSC = 2
ILE_PIACHU = 4

siatka = Piasek()
siatka.wczytaj_z_pliku(sciezka)

OKNOGRY_SZER = siatka.org_x * WIELKOSC
OKNOGRY_WYS = siatka.org_y * WIELKOSC
OKNOGRY = pygame.display.set_mode((OKNOGRY_SZER, OKNOGRY_WYS), 0, 32)
pygame.display.set_caption('Piasek')

generuj = True
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        

    if siatka.krok % CZESTOTLIWOSC == 0 and generuj:
        siatka.generuj_piasek(ILE_PIACHU)

    siatka.zrob_krok()
                
    OKNOGRY.fill((0, 0, 0))
    rysuj_piasek(siatka)
    pygame.display.update()
    pygame.time.delay(SZYBKOSC)
