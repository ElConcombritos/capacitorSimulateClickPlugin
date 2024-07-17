import { SimulateClickPlugin } from 'capacitor-simulate-click-plugin';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    SimulateClickPlugin.echo({ value: inputValue })
}
