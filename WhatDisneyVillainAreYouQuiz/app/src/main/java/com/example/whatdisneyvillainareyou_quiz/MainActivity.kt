package com.example.whatdisneyvillainareyou_quiz

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    // Declaring UI components
    private lateinit var toolbar: Toolbar
    private lateinit var nameInput: EditText
    private lateinit var ageInput: EditText
    private lateinit var colorSpinner: Spinner
    private lateinit var petRadioGroup: RadioGroup
    private lateinit var schemingSpinner: Spinner
    private lateinit var traitGreedy: CheckBox
    private lateinit var traitVengeful: CheckBox
    private lateinit var traitPowerHungry: CheckBox
    private lateinit var traitMagical: CheckBox
    private lateinit var traitManipulative: CheckBox
    private lateinit var weaponSpinner: Spinner
    private lateinit var submitButton: Button
    private lateinit var resultText: TextView
    private lateinit var villainLogo: ImageView

    // Data for spinners
    private val colors = arrayOf(
        "Purple", "Black", "Red", "Green", "Blue",
        "Gold", "Silver", "Orange", "Pink", "Teal"
    )

    private val weapons = arrayOf(
        "Magic Staff", "Poison", "Dagger", "Mind Control",
        "Minions", "Traps", "Dark Magic", "Sword", "Claws"
    )

    private val schemingLevels = arrayOf(
        "1 - Barely Evil", "2 - Mildly Mischievous", "3 - Somewhat Sneaky",
        "4 - Decently Devious", "5 - Moderately Malevolent", "6 - Quite Cunning",
        "7 - Very Villainous", "8 - Extremely Evil", "9 - Diabolically Devious", "10 - Ultimate Evil Mastermind"
    )

    // Villain data
    private val villains = mapOf(
        "Maleficent" to "You are MALEFICENT! Powerful and commanding, you're a force to be reckoned with. Your magical abilities and dramatic flair make you an iconic villain who knows how to make an entrance!",
        "Ursula" to "You are URSULA! Cunning and manipulative, you're a master of deals and deception. Your larger-than-life personality and theatrical nature make you unforgettable!",
        "Scar" to "You are SCAR! Intelligent and calculating, you play the long game. Your sharp wit and ability to manipulate others make you a dangerous adversary who nearly achieved your perfect kingdom!",
        "Cruella De Vil" to "You are CRUELLA DE VIL! Fashionable and obsessive, you know what you want and will stop at nothing to get it. Your dramatic style and unwavering determination make you truly unforgettable!",
        "Jafar" to "You are JAFAR! Power-hungry and scheming, you're always the smartest person in the room. Your mastery of magic and manipulation would make you a worthy ruler if not for those meddling heroes!",
        "Evil Queen" to "You are the EVIL QUEEN! Vain and ruthless, your beauty is matched only by your cruelty. Your commanding presence and willingness to do anything for your goals make you truly terrifying!",
        "Hades" to "You are HADES! Quick-witted and sarcastic, your fiery temper matches your domain. Your smooth-talking negotiation skills and flair for the dramatic make you a villain with style!",
        "Captain Hook" to "You are CAPTAIN HOOK! Vengeful and obsessive, you never forget a slight. Your refined manners barely conceal your ruthless nature, making you a pirate captain of legendary status!",
        "Gaston" to "You are GASTON! Arrogant and self-absorbed, nobody does villainy like you! Your charisma and physical strength make you a dangerous foe, especially when you don't get what you want!"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initializeViews()
        setSupportActionBar(toolbar)
        setupSpinners()
        setupSubmitButton()
    }

    private fun initializeViews() {
        toolbar = findViewById(R.id.toolbar)
        nameInput = findViewById(R.id.nameInput)
        ageInput = findViewById(R.id.ageInput)
        colorSpinner = findViewById(R.id.colorSpinner)
        petRadioGroup = findViewById(R.id.petRadioGroup)
        schemingSpinner = findViewById(R.id.schemingSpinner)
        traitGreedy = findViewById(R.id.traitGreedy)
        traitVengeful = findViewById(R.id.traitVengeful)
        traitPowerHungry = findViewById(R.id.traitPowerHungry)
        traitMagical = findViewById(R.id.traitMagical)
        traitManipulative = findViewById(R.id.traitManipulative)
        weaponSpinner = findViewById(R.id.weaponSpinner)
        submitButton = findViewById(R.id.submitButton)
        resultText = findViewById(R.id.resultText)
        villainLogo = findViewById(R.id.villainLogo)
    }

    private fun setupSpinners() {
        // Setup color spinner
        val colorAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            colors
        )
        colorSpinner.adapter = colorAdapter

        // Setup weapon spinner
        val weaponAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            weapons
        )
        weaponSpinner.adapter = weaponAdapter

        // Setup scheming level spinner
        val schemingAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            schemingLevels
        )
        schemingSpinner.adapter = schemingAdapter
        schemingSpinner.setSelection(4) // Default to middle valu
    }

    private fun setupSubmitButton() {
        submitButton.setOnClickListener {
            if (validateInputs()) {
                calculateVillain()
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateInputs(): Boolean {
        // Check that name and age are provided
        if (nameInput.text.isNullOrEmpty() || ageInput.text.isNullOrEmpty()) {
            return false
        }

        // Check that a pet is selected
        if (petRadioGroup.checkedRadioButtonId == -1) {
            return false
        }

        return true
    }

    private fun calculateVillain() {
        // Get input values
        val name = nameInput.text.toString()
        val age = ageInput.text.toString().toInt()
        val color = colorSpinner.selectedItem.toString()

        // Get pet selection
        val selectedPetId = petRadioGroup.checkedRadioButtonId
        val selectedPet = findViewById<RadioButton>(selectedPetId).text.toString()

        // Get scheming value
        val schemingValue = schemingSpinner.selectedItemPosition + 1

        // Get selected traits
        val traits = mutableListOf<String>()
        if (traitGreedy.isChecked)
            traits.add("Greedy")
        if (traitVengeful.isChecked)
            traits.add("Vengeful")
        if (traitPowerHungry.isChecked)
            traits.add("Power-hungry")
        if (traitMagical.isChecked)
            traits.add("Magical")
        if (traitManipulative.isChecked)
            traits.add("Manipulative")

        // Get weapon
        val weapon = weaponSpinner.selectedItem.toString()


        // Decide which villain you are
        val villain = determineVillain(name, age, color, selectedPet, schemingValue, traits, weapon)

        // Display result
        resultText.text = villain
        resultText.visibility = View.VISIBLE
    }

    private fun determineVillain(name: String, age: Int, color: String, pet: String, schemingValue: Int, traits: List<String>, weapon: String, ): String {
        // Calculate villain points for each villain
        var malificentPoints = 0
        var ursulaPoints = 0
        var scarPoints = 0
        var cruellaPoints = 0
        var jafarPoints = 0
        var evilQueenPoints = 0
        var hadesPoints = 0
        var captainHookPoints = 0
        var gastonPoints = 0

        // Color preferences
        when (color) {
            "Purple" -> { malificentPoints += 3; ursulaPoints += 2 }
            "Black" -> { malificentPoints += 2; scarPoints += 3; jafarPoints += 1 }
            "Red" -> { cruellaPoints += 2; evilQueenPoints += 3; gastonPoints += 2 }
            "Green" -> { ursulaPoints += 2; scarPoints += 1 }
            "Blue" -> { ursulaPoints += 3; hadesPoints += 1 }
            "Gold" -> { jafarPoints += 3; evilQueenPoints += 2 }
            "Silver" -> { captainHookPoints += 3; cruellaPoints += 1 }
            "Orange" -> { hadesPoints += 3 }
            "Pink" -> { cruellaPoints += 3 }
            "Teal" -> { ursulaPoints += 2; jafarPoints += 1 }
        }

        // Pet preferences
        when (pet) {
            "Cat" -> { scarPoints += 2; evilQueenPoints += 1 }
            "Dog" -> { cruellaPoints += 3; gastonPoints += 1 }
            "Bird" -> { jafarPoints += 3; malificentPoints += 1 }
            "Snake" -> { jafarPoints += 2; scarPoints += 1 }
            "Other" -> { ursulaPoints += 2; hadesPoints += 2; captainHookPoints += 1 }
        }

        // Scheming ability
        when (schemingValue) {
            in 1..3 -> { gastonPoints += 3; captainHookPoints += 2 }
            in 4..6 -> { cruellaPoints += 2; hadesPoints += 2; ursulaPoints += 1 }
            in 7..8 -> { jafarPoints += 2; scarPoints += 3; evilQueenPoints += 2 }
            in 9..10 -> { malificentPoints += 3; ursulaPoints += 2; jafarPoints += 2 }
        }

        // Traits
        for (trait in traits) {
            when (trait) {
                "Greedy" -> { ursulaPoints += 2; cruellaPoints += 3; scarPoints += 1 }
                "Vengeful" -> { malificentPoints += 3; captainHookPoints += 3; scarPoints += 2 }
                "Power-hungry" -> { jafarPoints += 3; scarPoints += 3; evilQueenPoints += 2; hadesPoints += 1 }
                "Magical" -> { malificentPoints += 3; ursulaPoints += 3; jafarPoints += 3; evilQueenPoints += 2; hadesPoints += 3 }
                "Manipulative" -> { ursulaPoints += 3; scarPoints += 3; jafarPoints += 2; gastonPoints += 2 }
            }
        }

        // Weapon
        when (weapon) {
            "Magic Staff" -> { malificentPoints += 3; jafarPoints += 3 }
            "Poison" -> { evilQueenPoints += 3; scarPoints += 1 }
            "Dagger" -> { scarPoints += 2; captainHookPoints += 1 }
            "Mind Control" -> { ursulaPoints += 2; jafarPoints += 1 }
            "Minions" -> { ursulaPoints += 2; cruellaPoints += 2; malificentPoints += 1; gastonPoints += 3 }
            "Traps" -> { scarPoints += 2; cruellaPoints += 1 }
            "Dark Magic" -> { malificentPoints += 3; ursulaPoints += 3; jafarPoints += 2; evilQueenPoints += 2; hadesPoints += 3 }
            "Sword" -> { captainHookPoints += 3; gastonPoints += 1 }
            "Claws" -> { scarPoints += 3 }
        }

        // Age factor
        if (age < 25) {
            gastonPoints += 2
        } else if (age < 40) {
            scarPoints += 1
            jafarPoints += 1
            ursulaPoints += 1
        } else {
            evilQueenPoints += 2
            cruellaPoints += 1
        }


        // Determine the highest score
        val scores = mapOf(
            "Maleficent" to malificentPoints,
            "Ursula" to ursulaPoints,
            "Scar" to scarPoints,
            "Cruella De Vil" to cruellaPoints,
            "Jafar" to jafarPoints,
            "Evil Queen" to evilQueenPoints,
            "Hades" to hadesPoints,
            "Captain Hook" to captainHookPoints,
            "Gaston" to gastonPoints
        )

        val highestVillain = scores.maxByOrNull { it.value }?.key ?: "Maleficent"

        // Return the villain description
        return villains[highestVillain] ?: "You are a completely unique villain!"
    }
}