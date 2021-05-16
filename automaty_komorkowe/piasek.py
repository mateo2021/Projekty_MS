import random




class Piasek:
    def __init__(self):
        self.siatka = []
        self.org_x = 0
        self.org_y = 0
        self.max_x = 0
        self.max_y = 0
        self.krok = 0

    def wczytaj_z_pliku(self, sciezka):
        with open(sciezka) as plik:
            tmp = plik.readlines()
    
        self.org_x = len(tmp[0])
        self.org_y = len(tmp)
        
        
        
        if self.org_x % 2 == 0:
            l_x = 1
            p_x = 1
        else:
            l_x = 1
            p_x = 0

        if self.org_y % 2 == 0:
            d_y = 0
        else:
            d_y = 1

        self.max_x = l_x + self.org_x + p_x
        self.max_y = self.org_y + d_y

        self.siatka = [[' '] * self.max_x for i in range(self.max_y)]

#SPOTYKA I WYPELNIA
        for i in range(self.org_y):
            for j in range(self.org_x):
                if tmp[i][j] == 'X':
                    self.siatka[i][j+1] = 'X'
                elif tmp[i][j] == 'W':
                    self.siatka[i][j+1] = 'W'
                else:
                    self.siatka[i][j+1] = ' '
        
    def generuj_piasek(self, ile_piachu):
        for i in range(ile_piachu):
            los = random.randint(3,self.org_x - 3)
            self.siatka[0][los] = 'O'

    
    
    def zrob_krok(self):
        if self.krok % 2 == 0:
            for i in range(0, self.max_y-1, 2):
                for j in range(1, self.max_x -2, 2):
                    self.ify(i,j)  
                               
        else :
            for i in range(1, self.max_y - 2, 2):
                for j in range(0, self.max_x-1, 2):
                    self.ify(i,j)
        
        
        self.krok += 1         
    
    
    
    
    
    def ify(self ,i,j):
        if self.siatka[i][j] == 'O' and self.siatka[i+1][j] == ' ':
            self.siatka[i][j] = ' '
            self.siatka[i+1][j] = 'O'

        if self.siatka[i][j+1] == 'O' and self.siatka[i+1][j+1] == ' ':
            self.siatka[i][j+1] = ' '
            self.siatka[i+1][j+1] = 'O'

        if self.siatka[i][j] == 'O' and self.siatka[i+1][j] == 'W':
            self.siatka[i][j] = ' '
                        
        if self.siatka[i][j+1] == 'O' and self.siatka[i+1][j+1] == 'W':
            self.siatka[i][j+1] = ' '
                        
        if self.siatka[i][j] == 'O' and self.siatka[i+1][j] == 'O' and self.siatka[i][j+1] == ' ' and self.siatka[i+1][j+1] == ' ':
            self.siatka[i][j] = ' '
            self.siatka[i+1][j+1] = 'O'

        if self.siatka[i][j+1] == 'O' and self.siatka[i+1][j+1] == 'O' and self.siatka[i][j] == ' ' and self.siatka[i+1][j] == ' ':
            self.siatka[i][j+1] = ' '
            self.siatka[i+1][j] = 'O'                     
        
        
        
        
        