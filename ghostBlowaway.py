def on_received_number(receivedNumber):
    global x
    if receivedNumber == 0:
        if x > 0:
            x += -1
            ghost.show_image(x)
radio.on_received_number(on_received_number)

ghost: Image = None
x = 0
radio.set_group(1)
x = 5
ghost = images.icon_image(IconNames.GHOST)
ghost.show_image(5)

def on_forever():
    global x
    if input.sound_level() > 128:
        if x < 5:
            x += 1
            ghost.show_image(x)
            radio.send_number(0)
basic.forever(on_forever)
