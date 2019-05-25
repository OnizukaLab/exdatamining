import pandas as pd
import glob

csv_list = glob.glob('./*.csv')

tmp = list()
for csv in csv_list:
    dt = pd.read_csv(csv)
    for i in range(1,len(dt)-1):
        tmp.append([ dt.ix[i,0][:12].replace(' ',''), dt.ix[i,0][12:24].replace(' ',''), dt.ix[i,0][24:36].replace(' ',''), dt.ix[i,0][36:48].replace(' ','') ])
        print(i)
    print(csv)
df = pd.DataFrame(tmp, columns = ['id', 'item', 'category', 'price'])

df.to_csv('experiment.csv', encoding = 'utf-8', index = False)
