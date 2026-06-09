package com.example.roadrunnerdispatch

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import roadrunnerdispatch.composeapp.generated.resources.Res
import roadrunnerdispatch.composeapp.generated.resources.roadrunnerdispatchlogo

val orange = Color(0xFFD15315)
val blue = Color(0xFF235A98)
val tan = Color(0xFFFEF4C8)

@Composable
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .border(10.dp, orange, RoundedCornerShape(52.dp))
                .background(Color.White)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(Res.drawable.roadrunnerdispatchlogo),
                contentDescription = "RoadRunnerDispatch Home Logo",
                modifier = Modifier.size(180.dp)
            )

            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Button(
                    modifier = Modifier.border(
                        4.dp,
                        Color.LightGray,
                        shape = RoundedCornerShape(20.dp)
                    ),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = orange),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Drives")
                }
                Button(
                    modifier = Modifier.border(
                        4.dp,
                        Color.LightGray,
                        shape = RoundedCornerShape(20.dp)
                    ),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = orange),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text("Add Drive")
                }
            }

            Text(
                modifier = Modifier.padding(top = 20.dp, bottom = 2.dp),
                text = "Active Drivers",
                textDecoration = TextDecoration.Underline,
                fontSize = 22.sp
            )

            // Get active drivers here
            LazyColumn(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(start = 4.dp, end = 4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Loop through active drivers and create composables
                /*
                for(fact in allFacts){
                    item {
                        Fact(fact = fact.toAPI())
                    }
                }
                 */
                item {
                    DriverCard("Clay", "Idle")
                }
            }
        }
    }
}

@Composable
fun Drives(){
    MaterialTheme{
        Column(
            modifier = Modifier
                .border(10.dp, orange, RoundedCornerShape(52.dp))
                .background(Color.White)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(Res.drawable.roadrunnerdispatchlogo),
                contentDescription = "RoadRunnerDispatch Home Logo",
                modifier = Modifier.size(180.dp)
            )

            Button(modifier = Modifier.border(4.dp, Color.LightGray, shape = RoundedCornerShape(20.dp)), onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = orange), shape = RoundedCornerShape(20.dp)) {
                Text("Add Drive")
            }

            Text(modifier = Modifier.padding(top = 20.dp, bottom = 2.dp), text = "Drives", textDecoration = TextDecoration.Underline, fontSize = 22.sp)

            // Get drives here
            LazyColumn(modifier = Modifier
                .wrapContentSize()
                .padding(start = 4.dp, end = 4.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                // Loop through active drives and create composables
                /*
                for(fact in allFacts){
                    item {
                        Fact(fact = fact.toAPI())
                    }
                }
                 */
                item {
                    DriveCard(type = "Dealer", action = "Trade", location = "Karl Malone ADS", status = "Active", pickupMachines = listOf("2026 YZ250"), dropoffMachines = listOf("2026 YZ450F"))
                }
            }
        }
    }
}

@Composable
fun AddDrive(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .border(10.dp, orange, RoundedCornerShape(52.dp))
            .background(Color.White)
            .safeContentPadding()
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(Res.drawable.roadrunnerdispatchlogo),
            contentDescription = "RoadRunnerDispatch Home Logo",
            modifier = Modifier.size(180.dp)
        )

        var selectedAction by remember { mutableStateOf("Pickup") }
        var selectedType by remember { mutableStateOf("Dealer") }
        var destination by remember { mutableStateOf("") }
        var customerName by remember { mutableStateOf("") }
        var customerPhone by remember { mutableStateOf("") }
        var urgent by remember { mutableStateOf(false) }
        var date = rememberDatePickerState()

        // Need to change type to Machine
        var machine1 by remember { mutableStateOf("") }
        var machine2 by remember { mutableStateOf("") }
        var machine3 by remember { mutableStateOf("") }
        var machine4 by remember { mutableStateOf("") }

        var machineCount by remember { mutableStateOf(1) }

        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(10.dp)){
            Row(modifier = Modifier.border(2.dp, orange, shape = AbsoluteCutCornerShape(5.dp))){
                listOf("Pickup", "Dropoff", "Trade").forEach { action ->
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable { selectedAction = action }
                            .padding(start = 10.dp, end = 10.dp)
                    ){
                        RadioButton(selected = selectedAction == action, onClick = {selectedAction = action}, colors = RadioButtonColors(Color.Black, Color.Black, Color.Black, Color.Black))
                        Text(action)
                    }
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(5.dp), modifier = Modifier.border(2.dp, orange, shape = AbsoluteCutCornerShape(5.dp))){
                listOf("Dealer", "Customer").forEach { type ->
                    Row(verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable { selectedType = type }
                            .padding(start = 10.dp, end = 10.dp)
                    ){
                        RadioButton(selected = selectedType == type, onClick = {selectedType = type}, colors = RadioButtonColors(Color.Black, Color.Black, Color.Black, Color.Black))
                        Text(type)
                    }
                }
            }
        }

        Column(horizontalAlignment = Alignment.Start, modifier = Modifier
            .border(2.dp, orange, shape = AbsoluteCutCornerShape(5.dp))){
            TextField(modifier = Modifier.height(50.dp), value = destination, onValueChange = { destination = it }, placeholder = { Text("Destination") })
            TextField(modifier = Modifier.height(50.dp), enabled = selectedType == "Customer", value = customerName, onValueChange = { customerName = it }, placeholder = { Text("Customer Name") })
            TextField(modifier = Modifier.height(50.dp), enabled = selectedType == "Customer", value = customerPhone, onValueChange = { customerPhone = it }, placeholder = { Text("Customer Phone") })
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(40.dp),
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            ){
                Row(verticalAlignment = Alignment.CenterVertically){
                    Checkbox(checked = urgent, onCheckedChange = { urgent = it })
                    Text("Urgent")
                }

                if(!urgent){
                    var showDialog by remember { mutableStateOf(false) }

                    Button(modifier = Modifier
                        .border(4.dp, Color.LightGray, shape = RoundedCornerShape(20.dp)),
                        onClick = { showDialog = true },
                        colors = ButtonDefaults.buttonColors(containerColor = orange),
                        shape = RoundedCornerShape(20.dp)) {
                        Text("Pick a date")
                    }
                    if(showDialog){
                        DatePickerDialog(
                            onDismissRequest = { showDialog = false },
                            confirmButton = {
                                TextButton(onClick = { showDialog = false }) {
                                    Text("OK")
                                }
                            }
                        ) {
                            DatePicker(state = date)
                        }
                    }
                }
            }
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp), horizontalAlignment = Alignment.CenterHorizontally){
            for(i in 0 until machineCount){
                Column(horizontalAlignment = Alignment.Start, modifier = Modifier
                    .border(2.dp, orange, shape = AbsoluteCutCornerShape(5.dp))
                    .padding(10.dp)){
                    MachineEditCard(type = selectedType, machineNum = i + 1)
                }
            }

            Button(modifier = Modifier.border(4.dp, Color.LightGray, shape = CutCornerShape(5.dp)), onClick = { machineCount++ }, colors = ButtonDefaults.buttonColors(containerColor = orange), shape = CutCornerShape(5.dp)){
                Text("+")
            }
        }
    }
}

@Composable
fun DriveInfo(){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .border(10.dp, orange, RoundedCornerShape(52.dp))
            .background(Color.White)
            .safeContentPadding()
            .fillMaxSize()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Image(
            painter = painterResource(Res.drawable.roadrunnerdispatchlogo),
            contentDescription = "RoadRunnerDispatch Home Logo",
            modifier = Modifier.size(180.dp)
        )

        val customerName = ""
        val customerPhone = ""
        val urgent = false
        Row(horizontalArrangement = Arrangement.spacedBy(100.dp)){
            Column(){
                Text("Action: ACTION")
                Text("Type: TYPE")
                Text("Location: LOCATION")
                if(customerName != "" && customerPhone != ""){
                    Text("Customer Name: NAME")
                    Text("Customer Phone: PHONE")
                }
                Text("Urgent: URGENCY")
                if(!urgent){
                    Text("Date: DATE")
                }
            }
        }

        // List of machines associated with the drive
        Column(){
            MachineInfoCard("P24235", "2026", "Polaris", "Pro R", "Dropoff", "", 1)
        }
    }
}

@Composable
fun DriverCard(name: String, status: String){
    Row(
        modifier = Modifier
            .clip(CutCornerShape(10.dp))
            .background(tan)
            .border(3.dp, orange, shape = CutCornerShape(10.dp))
            .padding(15.dp),
        horizontalArrangement = Arrangement.spacedBy(175.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(color = Color.Black, text = name, fontSize = 16.sp)
            Text(color = Color.Black, text = status, fontSize = 12.sp)
        }

        Button(
            modifier = Modifier
                .border(3.dp, Color.LightGray, shape = RoundedCornerShape(20.dp))
                .size(width = 75.dp, height = 40.dp),
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = orange),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Info")
        }
    }
}

@Composable
fun MachineEditCard(type: String, machineNum: Int){
    Column(modifier = Modifier
        .clip(CutCornerShape(10.dp))
        .background(tan)
        .border(3.dp, orange, shape = CutCornerShape(10.dp))
        .padding(15.dp)) {

        var vin by remember { mutableStateOf("") }
        var year by remember { mutableStateOf("") }
        var make by remember { mutableStateOf("") }
        var model by remember { mutableStateOf("") }
        var color by remember { mutableStateOf("") }
        var action by remember { mutableStateOf("") }

        Text("Machine $machineNum")
        TextField(
            modifier = Modifier.height(50.dp),
            value = vin,
            onValueChange = { vin = it },
            placeholder = { Text("VIN") })
        TextField(
            modifier = Modifier.height(50.dp),
            value = year,
            onValueChange = { year = it },
            placeholder = { Text("YEAR") })
        TextField(
            modifier = Modifier.height(50.dp),
            value = make,
            onValueChange = { make = it },
            placeholder = { Text("MAKE") })
        TextField(
            modifier = Modifier.height(50.dp),
            value = model,
            onValueChange = { model = it },
            placeholder = { Text("MODEL") })
        TextField(
            modifier = Modifier.height(50.dp),
            value = color,
            onValueChange = { color = it },
            placeholder = { Text("COLOR") })
        if (type == "Trade") {
            var machineSelectedAction by remember { mutableStateOf("") }
            Row(modifier = Modifier.border(2.dp, orange, shape = AbsoluteCutCornerShape(5.dp))) {
                listOf("Pickup", "Dropoff").forEach { action ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable { machineSelectedAction = action }
                            .padding(start = 10.dp, end = 10.dp)
                    ) {
                        RadioButton(
                            selected = machineSelectedAction == action,
                            onClick = { machineSelectedAction = action },
                            colors = RadioButtonColors(
                                Color.Black,
                                Color.Black,
                                Color.Black,
                                Color.Black
                            )
                        )
                        Text(action)
                    }
                }
            }
        }
    }
}

@Composable
fun MachineInfoCard(vin: String, year: String, make: String, model: String,type: String, action: String, machineNum: Int){
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .clip(CutCornerShape(10.dp))
        .background(tan)
        .border(3.dp, orange, shape = CutCornerShape(10.dp))
        .padding(15.dp)){
        Text("Machine $machineNum")
        Text("Vin: $vin")
        Text("Year: $year")
        Text("Make: $make")
        Text("Model: $model")
        if(type == "Trade" && action != ""){
            Text("Action: $action")
        }
    }
}

@Composable
fun DriveCard(type: String, action: String, location: String, status: String, pickupMachines: List<String>?, dropoffMachines: List<String>?){
    Row(
        modifier = Modifier
            .clip(CutCornerShape(10.dp))
            .background(tan)
            .border(3.dp, Color(0xFFD15315), shape = CutCornerShape(11.dp))
            .padding(6.dp),
        horizontalArrangement = Arrangement.spacedBy(100.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column() {
            Text(text = "$type $action", fontSize = 16.sp)
            Text(text = location, fontSize = 12.sp)
            if (action == "Pickup") {
                Row() {
                    Text(text = "Picking up: ", fontSize = 12.sp)
                    if (pickupMachines != null) {
                        if (pickupMachines.size > 1) {
                            for (i in 0 until pickupMachines.size) {
                                if (i < pickupMachines.size - 1) {
                                    Text(text = "${pickupMachines[i]} - ", fontSize = 12.sp)
                                } else {
                                    Text(text = pickupMachines[i], fontSize = 12.sp)
                                }
                            }
                        } else {
                            Text(text = pickupMachines[0], fontSize = 12.sp)
                        }
                    }
                }
            } else if (action == "Dropoff") {
                Row() {
                    Text(text = "Dropping off: ", fontSize = 12.sp)
                    if (dropoffMachines != null) {
                        if (dropoffMachines.size > 1) {
                            for (i in 0 until dropoffMachines.size) {
                                if (i < dropoffMachines.size - 1) {
                                    Text(text = "${dropoffMachines[i]} - ", fontSize = 12.sp)
                                } else {
                                    Text(text = dropoffMachines[i], fontSize = 12.sp)
                                }
                            }
                        } else {
                            Text(text = dropoffMachines[0], fontSize = 12.sp)
                        }
                    }
                }
            } else {
                Row() {
                    Text(text = "Picking up: ", fontSize = 12.sp)
                    if (pickupMachines != null) {
                        if (pickupMachines.size > 1) {
                            for (i in 0 until pickupMachines.size) {
                                if (i < pickupMachines.size - 1) {
                                    Text(text = "${pickupMachines[i]} - ", fontSize = 12.sp)
                                } else {
                                    Text(text = pickupMachines[i], fontSize = 12.sp)
                                }
                            }
                        } else {
                            Text(text = pickupMachines[0], fontSize = 12.sp)
                        }
                    }
                }

                Row() {
                    Text(text = "Dropping off: ", fontSize = 12.sp)
                    if (dropoffMachines != null) {
                        if (dropoffMachines.size > 1) {
                            for (i in 0 until dropoffMachines.size) {
                                if (i < dropoffMachines.size - 1) {
                                    Text(text = "${dropoffMachines[i]} - ", fontSize = 12.sp)
                                } else {
                                    Text(text = dropoffMachines[i], fontSize = 12.sp)
                                }
                            }
                        } else {
                            Text(text = dropoffMachines[0], fontSize = 12.sp)
                        }
                    }
                }
            }
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Button(
                modifier = Modifier.border(
                    3.dp,
                    Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                ).size(width = 75.dp, height = 40.dp),
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = blue),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("Info")
            }
            Text(text = status, fontSize = 12.sp)
        }
    }
}

@Composable
fun Signup(){
    Column(
        modifier = Modifier
            .border(10.dp, orange, RoundedCornerShape(52.dp))
            .background(Color.White)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(Res.drawable.roadrunnerdispatchlogo),
            contentDescription = "RoadRunnerDispatch Home Logo",
            modifier = Modifier.size(180.dp)
        )

        Text(modifier = Modifier.padding(bottom = 10.dp), text = "Signup")

        var username by remember {mutableStateOf("")}
        var password by remember {mutableStateOf("")}
        var shop by remember {mutableStateOf("")}

        TextField(modifier = Modifier.height(50.dp), value = username, onValueChange = { username = it }, placeholder = { Text("USERNAME") })
        TextField(modifier = Modifier.height(50.dp), value = password, onValueChange = { password = it }, placeholder = { Text("PASSWORD") })
        TextField(modifier = Modifier.height(50.dp), value = shop, onValueChange= { shop = it }, placeholder = { Text("SHOP") })

        Button(
            modifier = Modifier.border(
                4.dp,
                Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            ),
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = orange),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Register")
        }
    }
}

@Composable
fun Login(){
    Column(
        modifier = Modifier
            .border(10.dp, orange, RoundedCornerShape(52.dp))
            .background(Color.White)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(Res.drawable.roadrunnerdispatchlogo),
            contentDescription = "RoadRunnerDispatch Home Logo",
            modifier = Modifier.size(180.dp)
        )

        Text(modifier = Modifier.padding(bottom = 10.dp), text = "Login")

        var username by remember {mutableStateOf("")}
        var password by remember {mutableStateOf("")}
        var shop by remember {mutableStateOf("")}

        TextField(modifier = Modifier.height(50.dp), value = username, onValueChange = { username = it }, placeholder = { Text("USERNAME") })
        TextField(modifier = Modifier.height(50.dp), value = password, onValueChange = { password = it }, placeholder = { Text("PASSWORD") })
        TextField(modifier = Modifier.height(50.dp), value = shop, onValueChange= { shop = it }, placeholder = { Text("SHOP") })

        Button(
            modifier = Modifier.border(
                4.dp,
                Color.LightGray,
                shape = RoundedCornerShape(20.dp)
            ),
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = orange),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text("Login")
        }
    }
}

@Composable
fun Settings(){
    Column(
        modifier = Modifier
            .border(10.dp, orange, RoundedCornerShape(52.dp))
            .background(Color.White)
            .safeContentPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(Res.drawable.roadrunnerdispatchlogo),
            contentDescription = "RoadRunnerDispatch Home Logo",
            modifier = Modifier.size(180.dp)
        )

        Text(modifier = Modifier.padding(bottom = 10.dp), text = "Settings")

        // Shop name
        Text(text = "Shop Name")

        // Shop trucks
        Text(text = "Trucks")

        // Shop drivers
        Text(text = "Drivers")
    }
}