from datetime import  date
from snowpack.populate_tables import gen_url, insert_snowpack_data, date_list, extract_snowpack_data

months = {
    'January':1,
    'February':2,
    'March':3,
    'April':4,
    'May':5,
    'June':6,
    'July':7,
    'August':8,
    'September':9,
    'October':10,
    'November':11,
    'December':12
}

def scrape_snowpack_data(startdate, enddate ):
    dates = date_list(startdate, enddate)
    for date_ in dates:
        print(date_)
        url = gen_url(date_[0], date_[1],date_[2])
        print(date(int(date_[2]), months[date_[0]], int(date_[1])))
        insert_snowpack_data(extract_snowpack_data(url), date(int(date_[2]), months[date_[0]], int(date_[1])))

d1 = date(2015,2,1)
d2 = date(2016,2,1)
scrape_snowpack_data(d1,d2)

