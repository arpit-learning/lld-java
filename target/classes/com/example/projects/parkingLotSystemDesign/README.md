we want to build system that can be used to manage parking lot running in the machine of the booth operator.

What to design?
Complete E2E system

Do we need persistence?
Yes but in-memory only

How to communicate with system?
command-line

1. Support multiple floors.
2. Support multiple types of vehicles -> each vehicle will have its own type of parking slot.
3. Operator is present, tells you about availability.
4. A ticket is given at the time of entry :
   A. Ticket contains the vehicle type and vehicle number.
   B. Ticket contains time of entry
   C. Entry Gate Number
   D. Slot number is given to the customer at the time of entry in the ticket.
5. Vehicle can be parked in parking slot.
6. Slot becomes unavailable until the vehicle exits the parking lot.
7. At the exit gate the ticket is collected by the operator.
8. Calculates the fees based on the some criteria - like - time, vehicle type, slot type etc
9. Customer pays for the fees and gets a bill.
10. Bill contains -
    A. Entry time
    B. Exit time
    C. Amount
    D. Payment Ref Number
    E. Vehicle Number
11. There can be multiple payment modes -> Cash and Online
12. Fees will be charged on an hourly basis. It will have an upfront cost for the first hour, and then per hour charge
    will be implied.
13. Fees would be dynamic in nature,as in, when the capacity of the parking lot is almost full, or there is a high
    demand, the fees pricing and the model of pricing would change.
14. Different tiers of parking slots -
    A. Luxury area -> guards and stuff
    B. Normal Area -> everyday people
    C. Long term area -> weekly/monthly parking
    D. EV slots -> ev charging with additional cost is available.
15. A slot can be used only for the type of the vehicle it supports, car slot can’t accommodate a bike.
16. There can be multiple entry and exit gates.

