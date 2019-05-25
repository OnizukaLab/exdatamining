import pandas as pd
import glob

csv_list = glob.glob('./*.csv')

j = 1
a = 0
for csv in csv_list:
    tmp = list()
    print(csv)
    dt = pd.read_csv(csv)
    for i in range(1,len(dt)-1):
        tmp.append([ dt.ix[i,0][:12].replace(' ',''), dt.ix[i,0][12:24].replace(' ',''), dt.ix[i,0][24:36].replace(' ',''), dt.ix[i,0][36:48].replace(' ','') ])
        if i/len(dt)*100 > a:
            a+=1
            print(a)
    df = pd.DataFrame(tmp, columns = ['id', 'item', 'category', 'price'])
    df.to_csv('experiment'+'_'+j+'.csv', encoding = 'utf-8', index = False)
    j += 1
