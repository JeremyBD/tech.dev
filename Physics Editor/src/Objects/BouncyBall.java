package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class BouncyBall extends Environment.Object 
{
	public BouncyBall()
	{
		setWidth(25);
		setHeight(25);
		setX(420);
		setY(400);
		//setVx(1.0);
		//setVy(-1.0);
		
		appearance = new BufferedImage(getWidth(),getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = appearance.createGraphics();
		g.setColor(Color.white);
		g.fillOval(0, 0, getWidth(), getHeight());
	}
	
	public void hitGround(int groundLevel, double dydx)
	{ 
		double v = Math.sqrt(Math.pow(vx, 2)+Math.pow(vy,2));//calculate velocity
		double angleIncidence = Math.atan(vy/vx);
		if(angleIncidence < 0)
			angleIncidence=Math.PI+angleIncidence;
		double angleNormal = Math.atan(dydx);
		double angleReflection = 2*angleNormal - angleIncidence;
		setVx(v*0.5*Math.cos(angleReflection));
		setVy(v*0.5*Math.sin(angleReflection));
		if(Math.abs(v) < 1)
		{
			setVy(0.0);
			setVx(0.0);
		}
	}
}