package com.techtastic.minditup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Act5_Yoga extends AppCompatActivity {
    TextView edit;
    ImageView imageView;
    Button nbutton,pbutton;
    int current_image;
    int[] image = {R.drawable.halasana,R.drawable.balass , R.drawable.bandhasana , R.drawable.adho_mukha_svanasana,R.drawable.savasana};
    String [] textyoga = {"Benefits:\b\n1 - The Halasana is a proven remedy to help relieve anxiety and stress-related problems. When performed with breathing exercises, the plow pose helps provide relaxation to the mind. This asana relieves the stress-induced mental barriers, thereby promoting the overall well-being of an individual.\n2 - The plow pose is an effective remedy for various stomach disorders. Junk food and improper eating lifestyle lead to digestive system upsets that cause constipation, indigestion, and many more issues. The Halasana strengthens the colon and stimulates the digestive system through gentle massage. It results in proper digestion and absorption of the food ingested.\n\nSteps to perform Halasan:\nThe steps to perform Halasana are simple and easy to execute. These steps are-\n1 - Lie on your back with arms resting on the floor.\n3 - Inhale and lift the leg by 90 degrees.\n3)Slowly push your legs behind the head as you exhale. Remember to keep the shoulders and elbow as close as possible.Hold the pose for 20 minutes.\n 4 - Exhale and slowly return to the initial pose.\n",
            "Benefits:\n1 - Resting the forehead (namely the third eye or the spot between your eyebrows) on a yoga mat has an instant soothing effect on the brain. The forward fold of the body with eyes closed sends a signal to the nervous system that promotes feelings of safety, calm, and relaxation.\n2 - Balasana destresses your mind as well as your body and hence, lulls you into a state of calmness and relaxation. As this asana releases you from racing thoughts and anxiety to some extent, you get a good night's sleep and a very well-rested one at that. If you suffer from insomnia, this asana will be of great help. Undisturbed and peaceful sleep of a minimum of six hours is very important in staying motivated and healthy whereas disturbed sleep causes tiredness and low mood.\n\nSteps to perform Balasan\n1 - To practice this asana, the first step is to sit in a Vajrasana, which means, sit in a kneeling position with your hip touching your heels.\n2 - Close your eyes and take a few deep breaths.\n3 - The next step is to slowly bend your body towards your thighs and let your head touch the ground. Your palms should be placed next to your feet, and they should be facing upwards or the hands can be extended forward, before your head.\n4 - While maintaining this position, take long and deep breaths. Stay in this position for a minimum of five minutes, then gently return to the Vajrasana pose and slowly open your eyes.\n5 - You can also rub your hands and place them on your eyes before opening them.\n   ",
            "Benefits:\n1)Stretches the chest, neck, spine, and hips\n2)Strengthens the back, buttocks, and hamstrings\n3)Improves circulation of blood\n4)Helps alleviate stress and mild depression\n5)Calms the brain and central nervous system\n6)Stimulates the lungs, thyroid glands, and abdominal organs\n7)Improves digestion\n8)Helps relieve symptoms of menopause\n\nSteps to follow Bandhasana:\n1)Lie down flat on your back on a hard surface, preferably on a mat.\n2)Bend your knees and make sure to place your legs hip-width apart.\n3)Put your hands beside you with the palm facing downwards.\n4)Putting the pressure on the floor through your hands, lift your back.\n5)Lift such that your chin is touching your chest, without any movement or effort.\n6)Inhale and lift your torso is little up.\n7)Make sure your knees and ankles are aligned in a straight line.\n8)Your thighs should be parallel to the floor.\n9)Hold on to your breath for a few seconds and release.10)Repeat the process a few times.",
            "Benefits:\n1)Strengthens the muscles in your legs\n2)Increases the flow of blood to your brain\n3)May helps prevent carpal tunnel syndrome\n4)Strengthens your arms and shoulders\n5)Alleviates pain in the lower back\n6)Relieves stress and anxiety\n\nSteps to follow Adho Mukha Svanasana-\n1)Start by kneeling on the floor and keep your knees hip-width apart.\n2) Bend your upper body forward and place your hands on the floor, with your palms aligned in line with your shoulders. At this point, you should essentially be balancing your body on your knees, feet and palms.\n3) From this position, exhale, curl your toes and gently lift your knees off the floor. You should continue to face downward, and your heels should also not be in contact with the floor. This means you will now be balancing your body on your palms and your toes.\n4) Keep your knees and elbows bent slightly and take a couple of breaths.\n5) Now, lengthen your tailbone and straighten both your elbows and your knees. Bring your heels downward until they touch the floor. At this point, you should feel a nice stretch in your hamstrings.\n6) Hold the pose for a while and take a few deep breaths.\n7) Then, bend your knees and elbows and get back into the sitting position.\n",
            "Benefits:\n1)Helps alleviate stress and mild depression\n2)Reduces backache and headache\n3)Reduces fatigue, anxiety, and insomnia\n4)Rejuvenates tired legs\n5)Relieves symptoms of asthma and high blood pressure\n6)Therapeutic for hypertension, osteoporosis, and sinusitis\n\nSteps to perform Setu Bandhasana:\n1) Lying on your back, bend both knees and place the feet flat on the floor hip width apart. Slide the arms alongside the body with the palms facing down. The fingertips should be lightly touching the heels.\n2) Press the feet into the floor, inhale and lift the hips up, rolling the spine off the floor. Lightly squeeze the knees together to keep the knees hip width apart.\n3) Press down into the arms and shoulders to lift the chest up. Engage the legs, buttocks and mula bandha to lift the hips higher.\n4) Breathe and hold for 4-8 breaths.\n5) To release: exhale and slowly roll the spine back to the floor.\n"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act5_yoga);

        edit = findViewById(R.id.Edittext);
        imageView = findViewById(R.id.imageView);
        nbutton = findViewById(R.id.nextbutton);
        pbutton = findViewById(R.id.prevbutton);


        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current_image++;
                current_image = current_image%image.length;
                imageView.setImageResource(image[current_image]);
                edit.setText(textyoga[current_image]);

            }
        });
        pbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                current_image--;
                current_image = current_image%image.length;
                imageView.setImageResource(image[current_image]);
                edit.setText(textyoga[current_image]);

            }
        });

    }
}