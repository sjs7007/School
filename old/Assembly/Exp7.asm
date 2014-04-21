;BCD to HEX - Done

data segment
msg1 db 0dh,0ah,"Enter number : $"
msg2 db 0dh,0ah,"Number in hex. is : $"
abc dw ?
data ends

code segment
assume cs:code,ds:data
start:	
		mov ax,data
		mov ds,ax

		mov dx,offset msg1
		mov ah,09h
		int 21h


inputDigit:	mov ah,01h
			int 21h

			sub al,30h ;move input digit to si, -30 to get actual value from ascii
			mov [si],al

			inc si

			add al,30h ;check if i/p was enter, if not continue input
			cmp al,0dh
			jne inputDigit

			;now from 34 extract 3 by si-3,4 by si-2
			;3*10+4=34
			mov al,[si-3]
			mov bl,0ah
			mul bl
			mov dl,[si-2]
			mov dh,00h ;clear higher bits
			add ax,dx
			mov abc,ax

			;display msg
			mov dx,offset msg2
			mov ah,09h
			int 21h

			;why 4? maybe cause hex is 4 digit? - yes
			mov cl,04h
			mov ax,abc

loop1:	mov dx,00h ;clear higer bits
		mov bx,10h ;divide by 16
		div bx
		cmp dx,000ah ; if remainder is greater than 10, convert to alpha
		jnae loop2 ;push to stack loop
		add dx,0007h ; converting it to a-f if num>=10

loop2:	add dx,0030h ;convert back to ascii
		push dx
		dec cl
		jnz loop1
		mov cl,04h

display:	pop dx
			mov ah,02h
			int 21h
			dec cl
			cmp cl,00h
			jnz display

			mov ah,4ch
			int 21h

code ends
end start
