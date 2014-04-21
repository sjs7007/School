
Data Segment
Msg DB 0DH,0AH,"Hello$" ; This is a comment

Msg2 DB 0DH,0AH,"This is the second message$"
Data ends

Code Segment
Start:  MOV AX,Data
		MOV DS,AX  ;move data segment into accumulator
		MOV DX,OFFSET Msg ;move the message 'MSg'in dx register
		MOV AH,09H ;display character string
			INT 21H ;dos interrupt
		MOV DX,OFFSET Msg2 ; repeat above steps for the second message
                MOV AH,09H
                        INT 21H
		MOV AH,4CH ;return control to DOS. This should be present at end of all programs
			INT 21H
Code ends
end Start

;Each string in message should end with $
;OAH in message is for new line.If it is not included in each message it will overwrite the previously written line
;Steps to run : 1. masm <filename>.asm, link <filename>.obj, <filename> or use the batch file 'run' in Batch_Scripts folder

