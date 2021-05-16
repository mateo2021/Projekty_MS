#include <iostream>
#include <string>
#include <fstream>

#include <cstdlib>

using namespace std;


class Zawody
{
    string kierowca;
    double przejazd1,przejazd2,przejazd3,przejazd4;
public:

    Zawody();
    Zawody(double prz1,double prz2,double prz3,double prz4);

    void czasy(string czasy);
    void dane(string kierowca);
    double wyszukiwanie(string np,double nr);

    double sred();
    double minimum();

    string dane_kierowcy();

} ;

 Zawody::Zawody()
 {
       przejazd1=0;
       przejazd2=0;
       przejazd3=0;
       przejazd4=0;
       kierowca="";
}

Zawody::Zawody(double prz1,double prz2,double prz3,double prz4)
{
       przejazd1=prz1;
       przejazd2=prz2;
       przejazd3=prz3;
       przejazd4=prz4;
}

string Zawody::dane_kierowcy()
{
    return kierowca;
}
void  Zawody::dane (string kier)
{
    kierowca=kier.substr(0,kier.find("."));

}

double Zawody::sred()
{
    return  ((przejazd1+przejazd2+przejazd3+przejazd4)/4)/60;
}
double  Zawody::minimum()
{
        if((przejazd1<przejazd2&&przejazd1<przejazd3&&przejazd1<przejazd4)||(przejazd1==przejazd2,przejazd1==przejazd3,przejazd1==przejazd4))
        {
            return (przejazd1/60);
        }
        else if((przejazd2<przejazd1&&przejazd2<przejazd3&&przejazd2<przejazd4)||(przejazd2==przejazd1,przejazd2==przejazd3,przejazd2==przejazd4))
        {
            return (przejazd2/60);
        }
        else if ((przejazd3<przejazd1&&przejazd3<przejazd2&&przejazd3<przejazd4)||(przejazd3==przejazd1,przejazd3==przejazd2,przejazd3==przejazd4))
        {
            return (przejazd3/60);
        }
        else if((przejazd4<przejazd1&&przejazd4<przejazd2&&przejazd4<przejazd3)||(przejazd4==przejazd1,przejazd4==przejazd2,przejazd4==przejazd3))
        {
            return (przejazd4/60);
        }
}



double Zawody::wyszukiwanie(string np,double nr)
{
    string fragment;
    double fragment_konwersja;


    for(int i=0; i<nr; i++)
    {
        if(np.find(' ')<0)
        {

            np.replace(0,std::string::npos," ");
            fragment=np.substr(0,std::string::npos);
        }
        else
        {
           fragment=np.substr(0, np.find(' '));
         np.replace(0,np.find(' ')+1,"");
        }

    }
              // zamiana do double  przez atof
    {
         fragment_konwersja= atof(fragment.c_str());
             {
                 return fragment_konwersja;
             }

    }


}

void Zawody::czasy (string czasy)
{
    double  tablica[4];
    for(int i=0; i<4; i++)
    {
          tablica[i]=wyszukiwanie(czasy, i+1);
    }
     przejazd1=tablica[0];
     przejazd2=tablica[1];
     przejazd3=tablica[2];
     przejazd4=tablica[3];
}


int main()
{
    ifstream wczytaj_plik("plik.txt");
    Zawody XX();
              // dopisac sciezke dostepu
    string wynikowy;
    cout<<"Podaj sciezke do pliku wynikowego: ";
    cin>>wynikowy;
    ofstream zapisz_plik("wynik_odpowiedz.txt");


    cout<<"Dane zapisano do pliku wedlug podanej sciezki dostepu."<<endl;

    Zawody tablica[124];
    string wers1;
    string wers2;
    int X =0;

    getline(wczytaj_plik,wers1);
    zapisz_plik<<wers1<<endl;
    zapisz_plik<<"UWAGA !!!  Podane czasy zostaly przekonwertowane i sa podane w minutach!"<<endl;


    if(wczytaj_plik.good() == true) // wykonuje sie az nie osiagnie konca " eof"
    {
        while(!wczytaj_plik.eof())
        {
        getline(wczytaj_plik,wers1);
        getline(wczytaj_plik,wers2);

        tablica[X].dane(wers1);
        tablica[X].czasy(wers2);

        X++;
        }

    }

    int dodaj=1;   //dziala
    for(int j=0; j<(X-1); j++)
    {

    zapisz_plik<<dodaj<<" . "<<tablica[j].dane_kierowcy()<<" |--| "<<" Srednia przejazdu : "<<tablica[j].sred()<<" |--| "<<" Oraz czas minimalny: "<< tablica[j].minimum()<<endl;
            dodaj++;
    }
}


