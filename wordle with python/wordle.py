import sys

wordOfTheDay = sys.argv[1]

wordLetterList = [x for x in wordOfTheDay] # I created a list with letters of word of the day for check wrong position.
indicator = ["st","nd","rd","th","th","th"]

def wordle(wordOfTheDay):
    n = 0
    while n<8:
        n += 1

        if n <7:
            answerOfPlayer = input("Please write a word:").upper()  # Player can write as lower case so I used upper method for do upper case.
            
            if len(answerOfPlayer) == 5:        
                if answerOfPlayer == wordOfTheDay:
                    print("Try"+str(n)+" ("+answerOfPlayer+"): "+"Congratulations! You guess right in "+str(n)+indicator[n-1]+" shot!")
                    break

                print("Try"+str(n)+" ("+answerOfPlayer+"):")
                for i in range(5):
                    if answerOfPlayer[i] == wordOfTheDay[i]:
                        print(str(i+1)+". letter exists and located in right position.")

                    elif answerOfPlayer[i] in wordLetterList:
                        print(str(i+1)+". letter exists but located in wrong position.")
            
                    else:
                        print(str(i+1)+". letter does not exist.")

            else:
                print("Try"+str(n)+" ("+answerOfPlayer+"): "+"The length of word must be five!")
                
        else:
            print("You are failed!")
            break

wordle(wordOfTheDay) 