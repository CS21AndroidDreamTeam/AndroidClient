package com.historyquestwaifuedition.models

import com.historyquestwaifuedition.math.IntVec2D

class NonPlayableFactory {

    companion object {
        fun createNonPlayable(type: String): NonPlayable = when (type) {
            "Prehistoric Cave" -> {
                val leftChoice = DialogueNode("I like too. Here item found on stegosaurus walk")
                val rightChoice = DialogueNode("RAWWW!")
                val dialogue = DialogueNode("I am cave person and me hairy. Unga bunga, unga bunga. Do you like club?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Hairy Caveperson", dialogue, IntVec2D(0, 0))
            }
            "Medieval Wizards Tower" -> {
                val leftChoice = DialogueNode("Fool. You are not prepared. Here's an item instead to help you on your journey.")
                val rightChoice = DialogueNode("Typical mortal coward. Begone!")
                val dialogue = DialogueNode("Stay a while and listen travelers. I acquired forbidden knowledge and I have some to share. Would you like to put the wizard's hat on?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Wizard with Burning Hand", dialogue, IntVec2D(0, 0))
            }

            "Abandoned Cottage" -> {
                val leftChoice = DialogueNode("Nice try, we're dead not stupid. Here's an item anyway for playing along.")
                val rightChoice = DialogueNode("... then what are you doing here? Leave!")
                val dialogue = DialogueNode("We are spooky ghost children. OoooOooooOOooOOooooOOooOoooo. Are you my mommy?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Spooky Ghost Siblings", dialogue, IntVec2D(0, 0))
            }

            "Alchemists Laboratory" -> {
                val leftChoice = DialogueNode("... they are anime character and not real alchemists but I do love meeting new weebs. Here's an item for your journey.")
                val rightChoice = DialogueNode("I figured as much. Please see yourself out.")
                val dialogue = DialogueNode("Welcome. I am an alchemist that can't be bothered to turn my face to you. Did Alphonse and Elric send you?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Questionably Young Alchemist", dialogue, IntVec2D(0, 0))
            }

            "Viking Barracks" -> {
                val leftChoice = DialogueNode("I like your bravery but I'm a trained warrior who will crush you. Take this to help you get stronger.")
                val rightChoice = DialogueNode("You're a scaredy cat. Just as I expected. ")
                val dialogue = DialogueNode("Ja. I am a viking with braided hair and fancy sword. Fancy a duel?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Beautiful but lethal viking", dialogue, IntVec2D(0, 0))
            }

            "Roman Colosseum" -> {
                val leftChoice = DialogueNode("Right answer. Here's an item.")
                val rightChoice = DialogueNode("Begone, worm!")
                val dialogue = DialogueNode("Do all roads lead to Rome?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Oscar-winning Roman Soldier", dialogue, IntVec2D(0, 0))
            }

            "London Shop" -> {
                val leftChoice = DialogueNode("Right good answer, luv. Use this item wisely.")
                val rightChoice = DialogueNode("Bollocks!")
                val dialogue = DialogueNode("There's a 'ole in the bloody world like a great black pit and the bloody vermin o' the bleedin' world inhabit it and its morals ain't worth wot a pig can spit and it goes by the chuffin' name o' London, isit?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Posh lady with not so posh accent", dialogue, IntVec2D(0, 0))
            }

            "Futuristic Lab" -> {
                val leftChoice = DialogueNode("Omelette du fromage :)")
                val rightChoice = DialogueNode("Omelette du fromage :(")
                val dialogue = DialogueNode("Omelette du fromage?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Not Dexter", dialogue, IntVec2D(0, 0))
            }

            "Barbaric Outpost" -> {
                val leftChoice = DialogueNode("Noice! Here's an item")
                val rightChoice = DialogueNode("Not noice. ")
                val dialogue = DialogueNode("Do you even lift, bro?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Liftin' Barbarian", dialogue, IntVec2D(0, 0))
            }

            "Western Town" -> {
                val leftChoice = DialogueNode("Yee-Haw! Don't forget your item before heading to the range!")
                val rightChoice = DialogueNode("Aw... i-is it because I'm 12? B-b-BAKA!")
                val dialogue = DialogueNode("Let's go shooting today, senpai?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Cute Magical Girl Gunslinger", dialogue, IntVec2D(0, 0))
            }

            "Colonial Puritan Church" -> {
                val leftChoice = DialogueNode("JK, I don't know if you're even religious. Here's an item for your time.")
                val rightChoice = DialogueNode("Suit yourself, ya filthy casual. ")
                val dialogue = DialogueNode("Let us pray.",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("White Jesus", dialogue, IntVec2D(0, 0))
            }

            "Nazi Meeting Hall" -> {
                val leftChoice = DialogueNode("America EFF-YEAH. Here's a prize for your intolerance of intolerance.")
                val rightChoice = DialogueNode("...are you an undercover Nazi? *Not Captain America Punches you in the face*")
                val dialogue = DialogueNode("Should you punch Nazis?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Not Captain America", dialogue, IntVec2D(0, 0))
            }

            "Cold War Nuclear Site" -> {
                val leftChoice = DialogueNode("He blushes at you and drops an item for you to pick up")
                val rightChoice = DialogueNode("He charges at you. Time to book it!")
                val dialogue = DialogueNode("*growl *growl *admires freshly mutated nails while staring off in the distance",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Generic Mutant Man", dialogue, IntVec2D(0, 0))
            }

            "Chinese Pagoda" -> {
                val leftChoice = DialogueNode("*bork* *hands you an item")
                val rightChoice = DialogueNode("*growl")
                val dialogue = DialogueNode("Am I a good boy?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Not Inuyasha", dialogue, IntVec2D(0, 0))
            }


            "Beached Pirate Ship" -> {
                val leftChoice = DialogueNode("Sounds like a plan, matey. Take this item for compensation")
                val rightChoice = DialogueNode("Is it because I'm an octopus? I thought I had you fooled with me hat.")
                val dialogue = DialogueNode("Yarr. I'm a pirate with many arms since I enjoy multi-tasking. Want to join my crew?",
                    choiceLeft = leftChoice,
                    choiceRight = rightChoice)
                NonPlayable("Cap'n Oct", dialogue, IntVec2D(0, 0))
            }

            else -> throw IllegalArgumentException("This shouldn't be possible")
        }
    }

}