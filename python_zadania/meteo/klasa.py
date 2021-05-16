class Stacja: 
    def __init__(self,nr):
        self.max_temp_dob=-100.0 
        self.min_temp_dob=100.0
        self.avg_temp_dob={"suma":0.0,"liczba_rekordow":0}

        self.max_suma_opad=-100.0
        self.avg_suma_opad={"suma":0.0,"liczba_rekordow":0}
