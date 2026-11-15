@Composable
fun PinkyMenu() {
    var selectedTab by remember { mutableStateOf(0) }
    val tabs = listOf("AIM", "MENU", "MOD", "HOLO")

    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(id = R.drawable.tu_fondo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(modifier = Modifier.padding(16.dp)) {
            // TÍTULO
            Text(
                "PINKY MODZ",
                color = Color.Cyan,
                fontWeight = FontWeight.Black,
                fontSize = 22.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // PESTAÑAS DE ARRIBA - 2x2
            Row {
                tabs.take(2).forEachIndexed { i, t ->
                    TabButton(t, "Ver patch $t", selectedTab == i) { selectedTab = i }
                }
            }
            Row {
                tabs.drop(2).forEachIndexed { i, t ->
                    TabButton(t, "Ver patch $t", selectedTab == i + 2) { selectedTab = i + 2 }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text("Solicitar función", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)

            Spacer(modifier = Modifier.height(10.dp))

            // LISTA DE SWITCHES
            val items = listOf(
                "Aim Body" to "Activar en lobby",
                "Aim Drag" to "Activar en lobby",
                "Aim DragXAntenna" to "Activar al entrar al juego 40%",
                "Aim Magic" to "Activar en lobby"
            )

            items.forEach { (titulo, subtitulo) ->
                FeatureRow(titulo, subtitulo)
                Spacer(modifier = Modifier.height(10.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            // BOTÓN ABAJO
            Button(
                onClick = { /* abrir app */ },
                modifier = Modifier.fillMaxWidth().height(55.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White.copy(alpha = 0.3f))
            ) {
                Text("▶  ABRIR APP", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // BARRA ABAJO
            Row(
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(30.dp)).background(Color.White.copy(alpha = 0.3f)).padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text("🏠 Home")
                Text("📦 Funciones")
                Text("⚙️ Settings")
            }
        }
    }
}

@Composable
fun TabButton(titulo: String, subtitulo: String, seleccionado: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier.weight(1f).padding(4.dp).clip(RoundedCornerShape(16.dp))
            .background(if (seleccionado) Color.White.copy(alpha = 0.25f) else Color.Transparent)
            .clickable { onClick() }.padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(titulo, color = Color.White, fontWeight = FontWeight.Bold)
        Text(subtitulo, color = Color.White.copy(alpha = 0.7f), fontSize = 11.sp)
    }
}

@Composable
fun FeatureRow(titulo: String, subtitulo: String) {
    var encendido by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp))
            .background(Color.White.copy(alpha = 0.15f)).padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("📦", fontSize = 20.sp)
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(titulo, color = Color.White, fontWeight = FontWeight.Bold)
            Text(subtitulo, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
            Text("Apagado", color = Color.White.copy(alpha = 0.5f), fontSize = 11.sp)
        }
        Switch(checked = encendido, onCheckedChange = { encendido = it })
    }
}
