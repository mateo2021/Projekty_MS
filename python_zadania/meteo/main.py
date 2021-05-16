import os 
import re 
from klasa import Stacja 


sciezka_do_folderu=os.path.dirname(os.path.realpath(__file__))


sciezka_do_danych="/dane/"
lista_stacji=[
    "249180020",
    "352200375",
    "254180060",
    "350190566",
    "353180250"
]
stacje={nr:Stacja(nr) for nr in lista_stacji}

for root,dirs,files in os.walk(sciezka_do_folderu+sciezka_do_danych):
    for file_name in files:
        if re.match("^(o_d_.._....|s_d_.._....)\.csv$",file_name):
            file=open(root+file_name,"r") 
            content=file.readlines() 
            for line in content:
                linia=line.replace('"','').replace("\r\n","").split(",") 
                kod_stacji=linia[0] 
                if kod_stacji in lista_stacji: 
                    if re.match("^o_d_.._....\.csv$",file_name):
                        
                        dobowe_opady=float(linia[5]) 
                        stacje[kod_stacji].avg_suma_opad["suma"]+=dobowe_opady
                        stacje[kod_stacji].avg_suma_opad["liczba_rekordow"]+=1

                        if stacje[kod_stacji].max_suma_opad<dobowe_opady: 
                            stacje[kod_stacji].max_suma_opad=dobowe_opady

                    else: 

                        max_temp=float(linia[5]) 
                        min_temp=float(linia[7]) 
                        avg_temp=float(linia[9])

                       
                        stacje[kod_stacji].avg_temp_dob["suma"]+=avg_temp
                        stacje[kod_stacji].avg_temp_dob["liczba_rekordow"]+=1

                        if stacje[kod_stacji].max_temp_dob<max_temp:    
                            stacje[kod_stacji].max_temp_dob=max_temp

                        if stacje[kod_stacji].min_temp_dob<min_temp: 
                            stacje[kod_stacji].min_temp_dob=min_temp


for nr,stacja in stacje.items():
    if(stacja.max_temp_dob==-100.0): stacja.max_temp_dob="Brak danych"
    else: stacja.max_temp_dob=str(stacja.max_temp_dob)+"C"

    if(stacja.min_temp_dob==100.0): stacja.min_temp_dob="Brak danych"
    else: stacja.min_temp_dob=str(stacja.min_temp_dob)+"C"

    if(stacja.avg_temp_dob["liczba_rekordow"]==0): stacja.avg_temp_dob="Brak danych"
    else: stacja.avg_temp_dob=str(round((stacja.avg_temp_dob["suma"])/float(stacja.avg_temp_dob["liczba_rekordow"]),2))+"C"

    if(stacja.max_suma_opad==-100.0): stacja.max_suma_opad="Brak danych"
    else: stacja.max_suma_opad=str(stacja.max_suma_opad)+"mm"
    if(stacja.avg_suma_opad["liczba_rekordow"]==0): stacja.avg_suma_opad="Brak danych"
    else: stacja.avg_suma_opad=str(round((stacja.avg_suma_opad["suma"])/float(stacja.avg_suma_opad["liczba_rekordow"]),2))+"mm"
    
for nr,stacja in stacje.items():
    print("Stacja nr "+nr)
    print("\tMaksymalna zanotowana dobowa temperatura: "+str(stacja.max_temp_dob))
    print("\tMinimalna zanotowana dobowa temperatura: "+str(stacja.min_temp_dob))
    print("\tSrednia zanotowana dobowa temperatura: "+str(stacja.avg_temp_dob))
    print("")
    print("\tMaksymalna suma dobowa opadow: "+str(stacja.max_suma_opad))
    print("\tSrednia suma dobowa opadow: "+str(stacja.avg_suma_opad))
    print("")
