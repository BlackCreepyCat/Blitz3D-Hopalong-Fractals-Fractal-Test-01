; ----------------------------------------
; Name : Opalong Fractal By Filax/CreepyCat
; Date : (C)2025 
; Site : https://github.com/BlackCreepyCat
; ----------------------------------------
Graphics 1920, 1080, 32, 2
SetBuffer BackBuffer()

; Paramètres de la fractale
Global a# = 10
Global b# = 22
Global c# = 13

; Variables de position
Global x#, y#

; Variables pour les couleurs
Global red, green, blue


; Nombre de points à tracer
Const POINTS = 2000000

; Boucle de rendu
While Not KeyHit(1)
    Cls
	
	
    ; Centre de l'écran
    Origin GraphicsWidth() / 2, GraphicsHeight() / 2
	
    Local FrameCur = 0
    Local FrameMax = 1000
	
    For i = 1 To POINTS
		
		
		
        ; Calcul des nouvelles coordonnées
        Local newX# = y# + Sgn(x#) * Sqr(Abs(b# * x# - c#))
        Local newY# = a# - x#
		
        ; Calcul des nouvelles coordonnées
       ; Local newX# = y# + Sgn(x#) * Log(Abs(b# * x# - c#))
       ; Local newY# = a# - x#
		
		
        ; Générer des couleurs dynamiques avec plus de diversité
        red = Abs(Sin(newX * 0.2 + i * 0.045) * 255 + Cos(i * 0.05) * 128)
        green = Abs(Sin(newY * 0.15 + i * 0.025) * 255 + Cos(i * 0.07) * 128)
        blue = Abs(Sin((newX + newY) * 0.1 + i * 0.05) * 255 + Cos(i * 0.03) * 128)
		
		
		
		
        ; Appliquer la couleur
        Color red, green, blue
        Plot newX#, newY#
		
        ; Mise à jour des coordonnées
        x# = newX#
        y# = newY#
		
        ; Gestion du rafraîchissement d'écran tous les 5 frames
        FrameCur = FrameCur + 1
		
        If FrameCur > FrameMax Then 
			SeedRnd(MilliSecs())   
			
			
			Origin 0, 0
			Debug$ = "Iteration: " + Str(i) + " / " + Str(POINTS)
			Color 0, 0, 0
			Rect 10, 10, StringWidth(Debug$), StringHeight(Debug$)*3, 1
			
			
			Color 255, 255, 255
			Text 10, 10, Debug$
			
			Text 10, 20, a#
			Text 10, 30, b#
			Text 10, 40, c#
			
			Origin GraphicsWidth() / 2, GraphicsHeight() / 2
			
            Flip
            FrameCur = 0
        EndIf
		
		If KeyHit(57) Then Exit
		
    Next
	
    ; Afficher l'image calculée (en dehors de la boucle)
    Flip
Wend
End
;~IDEal Editor Parameters:
;~C#Blitz3D