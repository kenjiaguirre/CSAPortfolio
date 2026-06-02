def on_received_number(receivedNumber):
    if receivedNumber == 0:
        basic.show_leds("""
            . # . # .
            # . # . #
            # . . . #
            . # . # .
            . . # . .
            """)
        music.play(music.tone_playable(294, music.beat(BeatFraction.QUARTER)),
            music.PlaybackMode.UNTIL_DONE)
    elif receivedNumber == 1:
        basic.show_leds("""
            . . . . .
            . . . . .
            # # # # #
            . . . . .
            . . . . .
            """)
        music.play(music.tone_playable(262, music.beat(BeatFraction.WHOLE)),
            music.PlaybackMode.UNTIL_DONE)
    elif receivedNumber == 2:
        pass
    basic.clear_screen()
radio.on_received_number(on_received_number)

def on_logo_long_pressed():
    radio.send_number(1)
input.on_logo_event(TouchButtonEvent.LONG_PRESSED, on_logo_long_pressed)

def on_logo_pressed():
    radio.send_number(0)
input.on_logo_event(TouchButtonEvent.PRESSED, on_logo_pressed)

col = 0
row = 0
radio.set_group(1)
basic.show_icon(IconNames.GHOST)

def on_forever():
    global row, col
    for index in range(4):
        if input.sound_level() > 128:
            row = randint(0, 4)
            col = randint(0, 4)
            radio.send_number(2)
        if led.point(col, row):
            led.unplot(col, row)
            led.plot(col + 1, row)
basic.forever(on_forever)
