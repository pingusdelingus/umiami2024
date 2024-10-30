
def main():
    print("Week 11 Lab Practice")
    print("-" * 50)
    daysOfTheWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday']

    sales = []
    
#    print(daysOfTheWeek[0])
    #for index in range(0, len(daysOfTheWeek)):
    #    print(f"this is the {index} iteration: {daysOfTheWeek[index]}")
    salesSum = 0
    for day in daysOfTheWeek:
        usrInput = int(input(f"Enter the sales for {day}:"))
        sales.append(usrInput)
    for sale in sales:
        salesSum = salesSum + sale

    print(f"Total sales for the week: {salesSum:.2f}")





main()
